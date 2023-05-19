import axios from "axios";
import jwtDecode from "jwt-decode";
import router from "../../router";

const REST_API = `http://localhost:9999/api-`;
const UserIndex = {
  namespaced: true,
  state: {
    user: {},
    users: [],
    loginUser: null,
    loginUserinfo: null,
  },
  getters: {},
  mutations: {
    LOGIN_USER(state, payload) {
      let user = {
        userNo: payload["login-token"].userNo,
        userId: payload["login-token"].userId,
        userName: payload["login-token"].userName,
      };
      console.log(user);
      state.loginUser = user;
    },
    LOGOUT(state) {
      state.loginUser = null;
      state.loginUserinfo = null;
    },
    LOGIN_USER_INFO(state, payload) {
      let user = {
        userNo: payload["login-token"].userNo,
        userId: payload["login-token"].userId,
        userName: payload["login-token"].userName,
      };
      state.loginUserinfo = user;
    },
  },
  actions: {
    registUser({ commit }, user) {
      const API_URL = `${REST_API}user/user`;
      axios({
        url: API_URL,
        method: "POST",
        params: user,
      })
        .then((res) => {
          console.log(res);
          router.push("/login");
        })
        .catch((err) => {
          console.log(err);
        });

      commit;
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
          // console.log(res.data);

          const decoded = jwtDecode(res.data["login-token"]);
          // console.log(decoded);

          if (decoded["login-token"].auth == "true") {
            sessionStorage.setItem("login-token", res.data["login-token"]);
            localStorage.setItem(
              "console msg",
              // jwtDecode(res.data["login-token"].auth)
              // decoded["login-token"].auth
              "no"
            );
            commit("LOGIN_USER", decoded);
            alert("로그인 성공");
            router.replace({ name: "home" });
            // router.push("/regist");
          } else {
            alert("로그인 실패, 입력을 다시 확인해주세요");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    logout({ commit }) {
      sessionStorage.removeItem("login-token");
      commit("LOGOUT");
      router.push({ name: "login" });
    },
    loginUserinfo({ commit }) {
      const logintoken = sessionStorage.getItem("login-token");
      const decoded = jwtDecode(logintoken);
      if (logintoken == null) {
        router.push("/login");
      } else {
        commit("LOGIN_USER_INFO", decoded);
      }
    },
  },
  modules: {},
};

export default UserIndex;
