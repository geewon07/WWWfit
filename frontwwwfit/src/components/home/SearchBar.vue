<template>
  <div>
    <!-- <b-card-header header-tag="nav">
      <b-nav card-header tabs> -->
    <!-- <b-nav-item>'s with child routes. Note the trailing slash on the first <b-nav-item> -->
    <!-- <b-nav-item><router-link to="/search/result"  :videos="this.videos"
          :loginUserInfo="this.loginUserInfo" exact exact-active-class="active">동영상검색 결과</router-link></b-nav-item> -->
    <!-- <b-nav-item to="/search/bookmark" v-show="loginUserInfo"
            :loginUserInfo="this.loginUserInfo" exact exact-active-class="active">북마크</b-nav-item>
        <b-nav-form> -->
    <!-- <b-form-input
          v-model="keyword"
          size="lg"
          class="mr-lg-2"
          placeholder="Search"
        ></b-form-input> -->
    <!-- <b-button size="lg" class="my-2 my-sm" @click="search">Search</b-button>
      </b-nav-form>
      </b-nav>
    </b-card-header> -->
  </div>
</template>

<script>
// import BookmarkViewVue from "@/views/BookmarkView.vue";
// import SearchResultVue from "./SearchResult.vue";
import { mapState } from "vuex"; //v-if="getUser"

export default {
  name: "SearchBar",
  components: {
    // BookmarkViewVue,
    // SearchResultVue,
  },
  props: {
    loginUserInfo: {
      type: Object,
    },
  },
  data() {
    return {
      keyword: "",
    };
  },
  computed: {
    ...mapState({
      videos: (state) => state.UserIndex.videos,
    }),
  },
  created() {
    // this.search();
  },
  methods: {
    search() {
      this.$store.dispatch("PostIndex/search", "사무실 운동" + this.keyword);
    },
  },
};
</script>

<style></style>
