import axios from "axios";

const REST_API = `http://localhost:9999/api-`;
const PostIndex = {
  namespaced: true,
  state: {},
  getters: {},
  mutations: {},
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
  },
  modules: {},
};
export default PostIndex;
