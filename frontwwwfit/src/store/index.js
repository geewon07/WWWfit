import Vue from "vue";
import Vuex from "vuex";
import MypageIndex from "@/store/modules/MypageIndex.js";
import UserIndex from "./modules/UserIndex";
import PostIndex from "./modules/PostIndex";

Vue.use(Vuex);

const store = new Vuex.Store({
  modules: {
    MypageIndex,
    UserIndex,
    PostIndex,
  },
  state: {},
  getters: {},
  mutations: {},
  actions: {},
});

export default store;
