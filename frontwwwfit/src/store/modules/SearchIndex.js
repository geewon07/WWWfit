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
      console.log(state.videos);
    },
    GET_BOOKMARKS(state, payload) {
      state.bookmarks = payload;
    },
    GET_FOLDERS(state, payload) {
      state.bfolders = payload;
    },
  },
  actions: {
    search({ commit }, payload) {
      // if (localStorage.getItem("searchresult") != null) {
      //   commit(
      //     "SEARCH_VIDEO",
      //     JSON.parse(localStorage.getItem("searchresult"))
      //   );
      //   return;
      // }
      console.log("called search");
      const URL = "https://www.googleapis.com/youtube/v3/search";
      const API_KEY = process.env.VUE_APP_YOUTUBE_API_KEY; //process.env.VUE_APP_YOUTUBE_API_KEY;
      axios({
        url: URL,
        method: "GET", //default get방식
        params: {
          key: API_KEY,
          part: "snippet",
          q: payload,
          type: "video",
          maxResults: 10,
        },
      })
        .then((res) => {
          console.log("response" + res);
          console.log("response data" + res.data);
          console.log("response data items" + res.data.items);
          localStorage.setItem("searchresult", JSON.stringify(res.data.items));
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
    createBookmark({ commit }, bookmark) {
      const API_URL = `${REST_API}-bookmark/bookmark`;
      axios({
        url: API_URL,
        method: "POST",
        params: {
          bname: bookmark.bName,
          description: bookmark.description,
          posterSeq: bookmark.posterSeq,
          userNo: bookmark.userNo,
        },
      })
        .then((res) => {
          console.log(res + "posted bookmark");
          commit; // and refresh?
        })
        .catch((err) => {
          console.log("bookmark post error" + err);
        });
    },
  },
  modules: {},
};

export default UserIndex;
