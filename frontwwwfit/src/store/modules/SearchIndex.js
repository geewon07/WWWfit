import axios from "axios";

const REST_API = `http://localhost:9999/api`;
const UserIndex = {
  namespaced: true,
  state: {
    video: null,
    videos: [],
    bookmarks: [],
    bfolders: [],
  },
  getters: {},
  mutations: {
    SEARCH_VIDEO(state, payload) {
      state.videos = payload;
    },
    GET_BOOKMARKS(state, payload) {
      state.bookmarks = payload;
    },
  },
  actions: {
    search({ commit }, payload) {
      if(localStorage.getItem("searchresult")!=null){
        commit("SEARCH_VIDEO",localStorage.getItem("searchresult"));
        return;
      }
      console.log("called search");
      const URL = "https://www.googleapis.com/youtube/v3/search";
      const API_KEY = "AIzaSyBCO-66WLwAatfv9ne98gfQ1oJlBlYWNj8"; //process.env.VUE_APP_YOUTUBE_API_KEY;
      axios({
        url: URL,
        method: "GET", //default get방식
        params: {
          key: API_KEY,
          part: "snippet",
          q: payload,
          type: "video",
          maxResults: 1,
        },
      })
        .then((res) => {
          console.log(res);
          localStorage
          res.data.items
          commit("SEARCH_VIDEO", res.data.items);
          // return res.data.items;
        })
        .then((res) => {
          console.log(res);
          // this.searchresult.push(res);
          // this.searchresult = res;
          // const thumbimg = res[0].snippet.thumbnail.default["url"];
          // this.searchresult.push(thumbimg);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getBookmarks({ commit }, userNo) {
      const API_URL = `${REST_API}-bookmark/${userNo}`;
      axios({
        url: API_URL,
        method: "GET",
        params: {
          userNo,
        },
      }).then((res) => {
        commit("GET_BOOKMARKS", res.data);
      });
    },
    getFolders({ commit }, userNo) {
      const API_URL = `${REST_API}-bookmark/bookmark/folders`;
      axios({
        url: API_URL,
        method: "GET",
        params: {
          userNo,
        },
      }).then((res) => {
        commit("GET_FOLDERS", res.data);
      });
    },
  },
  modules: {},
};

export default UserIndex;
