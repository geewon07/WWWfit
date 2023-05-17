<template>
  <div>
    <b-navbar>
      <b-navbar-brand :to="{ name: 'home' }">
        <h3>logo placeholder</h3>
      </b-navbar-brand>
      <b-collapse id="nav-collaps" is-nav>
        <b-navbar-nav class="ml-auto">
          <b-nav-item :to="{ name: 'login' }">로그인</b-nav-item>
          <b-nav-item :to="{ name: 'regist' }">회원가입</b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
// import UserView from "./views/UserView.vue";
export default {
  name: "HeaderNav",
};
</script>

<style></style>
