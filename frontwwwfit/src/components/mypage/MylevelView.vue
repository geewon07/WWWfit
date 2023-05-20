<template>
  <div>MylevelView</div>
</template>

<script>
// 경험치, 연속 횟수, 이름,
// 연속일 수 count할 수 있는 값
import { mapState } from "vuex";
export default {
  props: ["loginUserInfo"],
  computed: {
    ...mapState({
      challengedays: (state) => state.MypageIndex.challengedays,
    }),
  },
  created() {
    this.$store.dispatch(
      "MypageIndex/getChallengedays",
      this.loginUserInfo.userNo
    );
  },
};
</script>

<style></style>
