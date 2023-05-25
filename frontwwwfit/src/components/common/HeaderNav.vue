<template>
  <div>
    <b-navbar>
      <b-navbar-brand to="/">
        <h3>WWWfit</h3>
      </b-navbar-brand>
      <b-collapse id="nav-collaps" is-nav>
        <b-navbar-nav>
          <b-nav-item
            :to="{ name: 'post' }"
            :loginUserInfo="loginUserInfo"
            :userLikes="userLikes"
          >
            포스터
          </b-nav-item>
        </b-navbar-nav>
        <b-navbar-nav class="ml-auto">
          <b-nav-item v-if="loginUserInfo" :to="{ name: 'mypage' }"
            >{{ loginUserInfo.userName }}님 마이페이지</b-nav-item
          >
          <b-nav-item v-if="!loginUserInfo" :to="{ name: 'login' }">
            로그인
          </b-nav-item>
          <b-nav-item v-else @click="logout">로그아웃</b-nav-item>
          <b-nav-item v-if="!loginUserInfo" :to="{ name: 'regist' }"
            >회원가입</b-nav-item
          >
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
// import UserView from "./views/UserView.vue";
import { mapState } from "vuex";
export default {
  name: "HeaderNav",
  data() {
    return {
      // loginUser: {},
    };
  },
  created() {
    if (this.loginUserInfo) {
      this.$store.dispatch("PostIndex/getUserLikes", this.loginUserInfo.userNo);
    }
  },
  computed: {
    ...mapState({
      loginUserInfo: (state) => state.UserIndex.loginUserInfo,
      userLikes: (state) => state.PostIndex.userLikes,
    }),
  },

  methods: {
    logout() {
      this.$store.dispatch("UserIndex/logout");
    },
  },
};
</script>

<style></style>
