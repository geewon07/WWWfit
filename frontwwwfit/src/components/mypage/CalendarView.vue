<template>
  <div>
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
  props: ["loginUserinfo"],
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
      imageurl: require("@/assets/pngegg.png"),
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
  },
  created() {
    this.$store
      .dispatch("MypageIndex/getCalendar", this.loginUserinfo.userNo)
      .then(() => {
        if (Array.isArray(this.calendars)) {
          this.calendarOptions.events = this.calendars.map((calendar) => ({
            start: calendar.start,
            extendedProps: {
              imageurl: this.imageurl,
            },
          }));
        } else {
          this.calendarOptions.events = [
            {
              start: this.calendars.start,
              extendedProps: {
                imageurl: this.imageurl,
              },
            },
          ];
        }
      });
    console.log(this.calendars);
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
