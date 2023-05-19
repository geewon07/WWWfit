<template>
  <div>
    <div v-if="getUser">
      <div b-container fluid="md">
        <calendar-view :loginUserinfo="loginUserinfo"></calendar-view>
      </div>
    </div>
    <div v-else></div>
  </div>
</template>

<script>
import CalendarView from "@/components/mypage/CalendarView.vue";
import { mapState } from "vuex";
export default {
  components: {
    CalendarView,
  },
  computed: {
    ...mapState({
      loginUserinfo: (state) => state.UserIndex.loginUserinfo,
    }),
    getUser() {
      return !!this.loginUserinfo;
    },
  },
  created() {
    this.$store.dispatch("UserIndex/loginUserinfo");
  },
};
</script>

<style></style>
