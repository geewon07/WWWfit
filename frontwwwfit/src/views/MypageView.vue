<template>
  <div>
    <div v-if="getUser">
      <div b-container fluid="md">
        <calendar-view :loginUserInfo="loginUserInfo"></calendar-view>
        <badge-view :loginUserInfo="loginUserInfo"></badge-view>
        <Mylevel-View :loginUserInfo="loginUserInfo"></Mylevel-View>
      </div>
    </div>
    <div v-else></div>
  </div>
</template>

<script>
import CalendarView from "@/components/mypage/CalendarView.vue";
import BadgeView from "@/components/mypage/BadgeView.vue";
import MylevelView from "@/components/mypage/MylevelView.vue";
import { mapState } from "vuex";
export default {
  components: {
    CalendarView,
    BadgeView,
    MylevelView,
  },
  computed: {
    ...mapState({
      loginUserInfo: (state) => state.UserIndex.loginUserInfo,
    }),
    getUser() {
      return !!this.loginUserInfo;
    },
  },
};
</script>

<style></style>
