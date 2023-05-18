import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import jwtDecode from "jwt-decode";
import router from "@/router";

Vue.use(Vuex);

const REST_API = `http://localhost:9999/api-`;
export default new Vuex.Store({
  state: {
    user: {},
    users: [],
    loginUser: {},
  },
  getters: {
    // getLoginUser() {
    //   return state.loginUser;
    // },
  },
  mutations: {
    CREATE_USER(state, payload) {
      state.user = payload.user;
    },
    LOGIN_USER(state, payload) {
      // state.loginUser.userNo = payload.userNo;
      state.loginUser.userNo = payload["login-token"].userNo;
      state.loginUser.userId = payload["login-token"].userId;
      state.loginUser.userName = payload["login-token"].userName;
    },
    LOGOUT(state) {
      state.loginUser = null;
    },
  },
  actions: {
    registUser({ commit }, payload) {
      commit("REGIST_USER", payload);
    },
    loginUser({ commit }, user) {
      // commit;
      const API_URL = `${REST_API}user/login`;
      // const API_URL="http://localhost:9999/api-user/login"

      axios({
        url: API_URL,
        method: "POST",
        params: user,
      })
        .then((res) => {
          // debugger;
          console.log(res);
          sessionStorage.setItem("login-token", res.data["login-token"]);
          localStorage.setItem(
            "console msg",
            jwtDecode(res.data["login-token"])
          );
          const decoded = jwtDecode(res.data["login-token"]);
          console.log(decoded);
          commit("LOGIN_USER", decoded);
          router.push("/");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    logout({ commit }) {
      sessionStorage.removeItem("login-token");
      commit("LOGOUT");
      // router.replace("/");
    },
  },
  modules: {},
});
