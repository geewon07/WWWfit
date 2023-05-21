<template>
  <div><h3>BadgeView</h3></div>
</template>

<script>
import { mapState } from "vuex";
export default {
  props: ["loginUserInfo"],
  computed: {
    ...mapState({
      badge: (state) => state.MypageIndex.badges,
    }),
  },
  created() {
    this.$store.dispatch("MypageIndex/getBadge", this.loginUserInfo.userNo);
  },
};
</script>

<style></style>
