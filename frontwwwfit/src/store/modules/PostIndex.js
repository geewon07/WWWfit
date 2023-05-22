import axios from "axios";

const REST_API = `http://localhost:9999/api-`;
const PostIndex = {
  namespaced: true,
  state: {
    poster: {},
    postList: [],
    userLikes: [],
    contentAVG: {},
  },
  getters: {},
  mutations: {
    GET_POSTER(state, payload) {
      state.poster = payload;
    },
    GET_POSTERS(state, payload) {
      state.postList = payload;
    },
    GET_USER_LIKES(state, payload) {
      state.userLikes = payload;
    },
    GET_RATING(state, payload) {
      state.contentAVG = payload;
    },
  },
  actions: {
    selectPoster({ commit }, posterSeq) {
      const API_URL = `${REST_API}poster/poster/${posterSeq}`;
      axios({
        url: API_URL,
        method: "GET",
        params: { posterSeq },
      }).then((res) => {
        console.log(res);
        commit("GET_POSTER", res.data);
      });
    },
    // getPoster({ commit }) {
    //   const API_URL = `${API_URL}poster/`;
    //   commit;
    // },
    getPosters({ commit }) {
      const API_URL = `${REST_API}poster/poster`;
      // commit;
      axios({
        url: API_URL,
        method: "GET",
      }).then((res) => {
        console.log(res.data);
        console.log("why does it renavigate");
        localStorage.setItem("fetch posters", res.data);
        commit("GET_POSTERS", res.data);
      });
    },
    getUserLikes({ commit }, userNo) {
      const API_URL = `${REST_API}like/user/${userNo}`;
      // commit;
      console.log("get user likes action called");
      axios({
        url: API_URL,
        method: "GET",
        params: { userNo },
      })
        .then((res) => {
          console.log(res.data);
          // console.log("why does it renavigate");
          localStorage.setItem("fetch userLikes", res.data);
          commit("GET_USER_LIKES", res.data);
        })
        .catch((err) => {
          console.log("in get userlikes axios error:" + err);
        });
    },
    likePoster({ commit }, like) {
      const API_URL = `${REST_API}like/like`;
      axios({
        url: API_URL,
        method: "POST",
        params: {
          loginUser: like.loginUser,
          posterSeq: like.posterSeq,
        },
      })
        .then((res) => {
          console.log(res);
          commit;
        })
        .catch((err) => {
          console.log("likeposter error:" + err);
        });
    },
    unlikePoster({ commit }, like) {
      const API_URL = `${REST_API}like/like`;
      axios({
        url: API_URL,
        method: "DELETE",
        params: {
          userNo: like.loginUser,
          posterSeq: like.posterSeq,
        },
      })
        .then((res) => {
          console.log(res);
          commit;
        })
        .catch((err) => {
          console.log("unlike error:" + err);
        });
    },
    getRating({ commit }, contentSeq) {
      const API_URL = `${REST_API}rating/rating`;

      axios({
        url: API_URL,
        method: "GET",
        params: { contentSeq },
      }).then((res) => {
        console.log("rating get " + res.data);
        // commit("GET_RATING");

        commit("GET_RATING", res.data);
        return res.data;
      });
    },
    ratePoster({ commit }, rating) {
      const API_URL = `${REST_API}rating/rating`;
      axios({
        url: API_URL,
        method: "POST",
        params: rating,
        // {
        //   rating: {
        //     contentSeq: rating.contentSeq,
        //     review: rating.review,
        //     score: rating.score,
        //     userNo: rating.userNo,
        //   },
        // },
      })
        .then((res) => {
          console.log(res.data);
          commit;
        })
        .catch((err) => {
          console.log("dorating err :" + err);
        });
    },
  },
  modules: {},
};
export default PostIndex;
