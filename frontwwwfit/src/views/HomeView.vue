<template>
  <div>
    <search-bar></search-bar>
    <search-result></search-result>
  </div>
</template>

<script>
import SearchResult from "@/components/home/SearchResult.vue";
import SearchBar from "../components/home/SearchBar.vue";
export default {
  components: { SearchBar, SearchResult },
  name: "HomeView",
};
</script>

<style></style>
