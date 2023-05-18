<template>
  <div>
    <post-list-view v-if="getUser"></post-list-view>
    <search-bar></search-bar>
    <search-result></search-result>
  </div>
</template>

<script>
import SearchResult from "@/components/home/SearchResult.vue";
import SearchBar from "../components/home/SearchBar.vue";
import PostListView from "@/components/post/PostListView.vue";
import { mapState } from "vuex";
export default {
  components: { SearchBar, SearchResult, PostListView },
  name: "HomeView",
  computed: {
    ...mapState(["loginUser"]),
    getUser() {
      if (this.loginUser) {
        return true;
      } else {
        return false;
      }
    },
  },
};
</script>

<style></style>
