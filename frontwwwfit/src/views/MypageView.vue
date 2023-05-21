<template>
  <div>
    <div v-if="getUser">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-12">
            <MylevelView :loginUserInfo="loginUserInfo" />
          </div>
        </div>
        <div class="row">
          <div class="col-md-6">
            <CalendarView :loginUserInfo="loginUserInfo" />
          </div>
          <div class="col-md-6">
            <div class="row">
              <div class="col-md-12">
                <NotificationView :loginUserInfo="loginUserInfo" />
              </div>
              <div class="col-md-12">
                <BadgeView :loginUserInfo="loginUserInfo" />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div v-else></div>
  </div>
</template>
<script>
import CalendarView from "@/components/mypage/CalendarView.vue";
import BadgeView from "@/components/mypage/BadgeView.vue";
import MylevelView from "@/components/mypage/MylevelView.vue";
import NotificationView from "@/components/mypage/NotificationView.vue";

import { mapState } from "vuex";
export default {
  components: {
    CalendarView,
    BadgeView,
    MylevelView,
    NotificationView,
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

<style scoped>
.mylevel-container {
  margin-bottom: 20px;
}
</style>
