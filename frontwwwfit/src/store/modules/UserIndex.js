import axios from "axios";
import jwtDecode from "jwt-decode";
import router from "../../router";
import firebase from "firebase/app";
import "firebase/messaging";

const REST_API = `http://localhost:9999/api-`;
const UserIndex = {
  namespaced: true,
  state: {
    user: {},
    users: [],
    loginUser: null,
    loginUserInfo: null,
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
      state.loginUserInfo = null;
    },
    LOGIN_USER_INFO(state, payload) {
      let user = {
        userNo: payload["login-token"].userNo,
        userId: payload["login-token"].userId,
        userName: payload["login-token"].userName,
      };
      state.loginUserInfo = user;
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
      const API_URL = `${REST_API}user/login`;
      const messaging = firebase.messaging();

      // getToken() 메서드 비동기 처리
      async function getToken() {
        try {
          const token = await messaging.getToken();
          return token;
        } catch (error) {
          console.log(error);
          return null;
        }
      }

      // getToken() 메서드 호출 후 axios 요청 실행
      getToken()
        .then((token) => {
          if (token) {
            // console.log(token);
            axios({
              url: API_URL,
              method: "POST",
              data: {
                token: token,
                userId: user.userId,
                userpassword: user.password,
              },
            })
              .then((res) => {
                // 요청 성공 처리
                const decoded = jwtDecode(res.data["login-token"]);
                if (decoded["login-token"].auth === "true") {
                  sessionStorage.setItem(
                    "login-token",
                    res.data["login-token"]
                  );
                  localStorage.setItem("console msg", "no");
                  commit("LOGIN_USER", decoded);
                  commit("LOGIN_USER_INFO", decoded);
                  alert("로그인 성공");
                  router.replace("/");
                } else {
                  alert("로그인 실패, 입력을 다시 확인해주세요");
                }
              })
              .catch((err) => {
                // 요청 실패 처리
                console.log(err);
              });
          } else {
            // 토큰이 없는 경우 처리
            console.log("토큰이 없습니다.");
          }
        })
        .catch((error) => {
          // getToken() 에러 처리
          console.log(error);
        });
    },
    logout(context) {
      sessionStorage.removeItem("login-token");
      context.commit("LOGOUT");
      context.dispatch("MypageIndex/resetCalendar", null, { root: true });
      router.push({ name: "login" });
    },
    loginUserInfo({ commit }) {
      const logintoken = sessionStorage.getItem("login-token");
      if (logintoken != null) {
        const decoded = jwtDecode(logintoken);
        if (logintoken == null) {
          // router.push("/login");
        } else {
          commit("LOGIN_USER_INFO", decoded);
        }
      }
    },
  },
  modules: {},
};

export default UserIndex;
