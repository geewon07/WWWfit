import axios from "axios";
const REST_API = `http://localhost:9999/api`;

const MypageIndex = {
  namespaced: true,
  state: {
    calendars: [],
    badges: {},
    mypageinfo: {},
    notification: [],
  },
  getters: {},
  mutations: {
    GET_CALENDAR(state, payload) {
      state.calendars = payload;
    },
    RESET_CALENDAR(state) {
      state.calendars = [];
    },
    GET_BADGE(state, payload) {
      state.badges = payload;
    },
    GET_CHALLENGEDAYS(state, payload) {
      state.challengedays = payload;
    },
    GET_MYPAGE(state, payload) {
      state.mypageinfo = payload;
    },
    GET_NOTIFICATION(state, payload) {
      state.notification = payload;
    },
  },
  actions: {
    getNotification({ commit }, userNo) {
      const API_URL = `${REST_API}_notification/notification/${userNo}`;
      axios({
        url: API_URL,
        method: "GET",
      }).then((res) => {
        commit;
        commit("GET_NOTIFICATION", res.data);
        console.log(res);
      });
    },
    getBadge({ commit }, userNo) {
      const API_URL = `${REST_API}_badge/badge/${userNo}`;

      axios({
        url: API_URL,
        method: "GET",
      }).then((res) => {
        commit("GET_BADGE", res.data);
      });
    },
    getCalendar({ commit }, userNo) {
      const API_URL = `${REST_API}_calendar/calendar/${userNo}`;

      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log(res);
          const events = [];
          if (Array.isArray(res.data)) {
            res.data.forEach((data) => {
              const start = data.calendarStart;
              const event = {
                start: start,
              };
              events.push(event);
            });
          } else {
            const start = res.data.calendarStart;
            const event = {
              start: start,
            };
            events.push(event);
          }
          const calendarData = {
            events: events,
          };
          console.log(calendarData);
          commit("GET_CALENDAR", calendarData);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    resetCalendar({ commit }) {
      commit("RESET_CALENDAR");
    },
    getMypage({ commit }, userNo) {
      const API_URL = `${REST_API}-user/mypage/${userNo}`;

      axios({
        url: API_URL,
        method: "GET",
      }).then((res) => {
        commit("GET_MYPAGE", res.data);
        console.log(res.data);
      });
    },
  },
  modules: {},
};
export default MypageIndex;
