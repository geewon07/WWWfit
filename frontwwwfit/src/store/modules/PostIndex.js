import axios from "axios";

const REST_API = `http://localhost:9999/api-`;
const PostIndex = {
  namespaced: true,
  state: {
    postList:[],
    video:null,
    videos:[],
    userLikes:[],

  },
  getters: {},
  mutations: {
    GET_POSTERS(state,payload){
      state.postList=payload;
    },
    GET_USER_LIKES(state,payload){
      state.userLikes=payload;
    },
    SEARCH_VIDEO(state,payload){
      state.videos=payload;
    }
  },
  actions: {
    getPosters({commit}){
      const API_URL=`${REST_API}poster/poster`;
      // commit;
      axios({
        url:API_URL,
        method:"GET"
      }).then((res)=>{
        console.log(res.data);
        console.log("why does it renavigate");
        localStorage.setItem("fetch posters",res.data);
        commit("GET_POSTERS",res.data)
      })
    },
    getUserLikes({commit},userNo){
      const API_URL=`${REST_API}like/user/${userNo}`;
      // commit;
      axios({
        url:API_URL,
        method:"GET",
        params:
        userNo,
      }).then((res)=>{
        console.log(res.data);
        // console.log("why does it renavigate");
        localStorage.setItem("fetch userLikes",res.data);
        commit("GET_USER_LIKES",res.data)
      })
    },
    search({commit},payload){
      console.log("called search")
      const URL = "https://www.googleapis.com/youtube/v3/search";
      const API_KEY = process.env.VUE_APP_YOUTUBE_API_KEY;
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

    }
  },
  modules: {},
};
export default PostIndex;
