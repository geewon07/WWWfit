<template>
  <div>
    <div></div>
    <FullCalendar :options="calendarOptions" />
  </div>
</template>

<script>
import FullCalendar from "@fullcalendar/vue";
import dayGridPlugin from "@fullcalendar/daygrid";
import { mapState } from "vuex";

export default {
  components: {
    FullCalendar,
  },
  props: ["loginUserInfo"],
  computed: {
    ...mapState({
      calendars: (state) => state.MypageIndex.calendars,
    }),
  },
  data() {
    return {
      calendarOptions: {
        plugins: [dayGridPlugin],
        initialView: "dayGridMonth",
        events: [],
        eventContent: this.customEventContent,
      },
      imageurl: require("@/assets/brand.png"),
    };
  },
  methods: {
    customEventContent(arg) {
      const imageurl = arg.event.extendedProps.imageurl;
      if (imageurl) {
        return {
          html: `
            <div class="event-content">
              <div class="event-sticker">
                <img src="${imageurl}" alt="Event Image" style="max-width: 50px; max-height: 50px;">
              </div>
            </div>
          `,
        };
      }
    },
    updateCalendarOptions() {
      if (Array.isArray(this.calendars.events)) {
        if (this.calendars.events.length > 0) {
          this.calendarOptions.events = [...this.calendars.events].map(
            (event) => ({
              start: event.start,
              extendedProps: {
                imageurl: this.imageurl,
              },
              backgroundColor: "rgb(247, 232, 255)",
              borderColor: "rgb(247, 232, 255)",
            })
          );
        } else {
          this.calendarOptions.events = [];
        }
      } else if (
        typeof this.calendars.events === "object" &&
        this.calendars.events !== null
      ) {
        this.calendarOptions.events = [
          {
            start: this.calendars.events.start,
            extendedProps: {
              imageurl: this.imageurl,
            },
            backgroudColor: "rgb(247, 232, 255)",
            borderColor: "rgb(247, 232, 255)",
          },
        ];
      } else {
        this.calendarOptions.events = [];
      }
    },
  },
  watch: {
    calendars: {
      handler() {
        this.updateCalendarOptions();
      },
      deep: true,
    },
  },
  created() {
    this.$store
      .dispatch("MypageIndex/getCalendar", this.loginUserInfo.userNo)
      .then(() => {
        this.updateCalendarOptions();
      })
      .catch((error) => {
        console.log(error);
      });
  },
};
</script>

<style scoped>
.event-content {
  display: flex;
  align-items: center;
}

.event-sticker {
  width: 50px;
  height: 50px;
  align-items: center;
}
</style>
