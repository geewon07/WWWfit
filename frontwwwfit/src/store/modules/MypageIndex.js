import axios from "axios";

const REST_API = `http://localhost:9999/api_`;
const MypageIndex = {
  namespaced: true,
  state: {
    calendars: [],
  },
  getters: {},
  mutations: {
    GET_CALENDAR(state, payload) {
      state.calendars = payload;
    },
  },
  actions: {
    getCalendar({ commit }, useNo) {
      const API_URL = `${REST_API}calendar/calendar/${useNo}`;

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
          commit("GET_CALENDAR", calendarData);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  modules: {},
};
export default MypageIndex;
