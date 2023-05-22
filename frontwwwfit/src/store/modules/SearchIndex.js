import axios from "axios";

const UserIndex = {
  namespaced: true,
  state: {
    video: null,
    videos: [],
  },
  getters: {},
  mutations: {
    SEARCH_VIDEO(state, payload) {
      state.videos = payload;
    },
  },
  actions: {
    search({ commit }, payload) {
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
  },
  modules: {},
};

export default UserIndex;
