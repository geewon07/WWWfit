<template>
  <div class="mylevel-container">
    <p class="title">알림</p>
    <div class="badge-container">
      <div v-if="notification.length !== 0">
        <b-list-group>
          <b-list-group-item
            v-for="noti in notification"
            :key="noti.notificationNo"
            >{{ noti.context }}
            <span class="date_font"
              >{{ getTimeDifference(noti.regDate) }}
            </span>
          </b-list-group-item>
        </b-list-group>
      </div>
      <div v-else class="noNotication_font">알람이 존재하지 않습니다.</div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  props: ["loginUserInfo"],
  computed: {
    ...mapState({
      notification: (state) => state.MypageIndex.notification,
    }),
  },
  created() {
    this.$store.dispatch(
      "MypageIndex/getNotification",
      this.loginUserInfo.userNo
    );
  },
  methods: {
    getTimeDifference(regDate) {
      const currentTime = new Date();
      // console.log(currentTime);
      const notificationTime = new Date(regDate);
      const timeDiff = currentTime.getTime() - notificationTime.getTime();
      const hoursDiff = Math.floor(timeDiff / (1000 * 60 * 60));
      // console.log(hoursDiff);
      if (hoursDiff < 24) {
        return `${hoursDiff} 시간 전`;
      } else {
        const daysDiff = Math.floor(hoursDiff / 24);
        return `${daysDiff} 일 전`;
      }
    },
  },
};
</script>

<style scoped>
.badge-container {
  background-color: #f8f8f8;
  border: 2px solid #ccc;
  border-radius: 4px;
  padding: 20px;
}
.noNotication_font {
  font-size: 25px;
}
.date_font {
  font-size: 14px;
  color: hsl(224, 95%, 58%);
}
</style>
