<template>
  <div id="app" style="background-color: #eee">
    <header-nav style="background-color: white"></header-nav>
    <router-view
      class="col-8 offset-2"
      style="background-color: white; padding: 0"
    />
  </div>
</template>

<script>
import HeaderNav from "./components/common/HeaderNav.vue";
// style="padding-left: 100px; padding-right: 100px;"
export default {
  components: {
    HeaderNav,
  },
  created() {
    this.$store.dispatch("UserIndex/loginUserInfo");
  },
};
</script>
<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  min-width: 750px;
  /* text-align: center; */
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
