<template>
  <div>
    <h1></h1>
    <div>
      <b-nav-form>
        <b-form-input
          v-model="keyword"
          size="lg"
          class="mr-lg-2"
          placeholder="Search"
        ></b-form-input>
        <b-button size="lg" class="my-2 my-sm" @click="search">Search</b-button>
      </b-nav-form>
      <b-nav pills>
        <!-- <b-nav-item :to="{ name: 'plist' }" :loginUserInfo="this.loginUserInfo">
          포스터리스트
        </b-nav-item> -->
        <b-nav-item
          :to="{ name: 'sresult' }"
          :videos="this.videos"
          :loginUserInfo="this.loginUserInfo"
        >
          동영상</b-nav-item
        >

        <b-nav-item
          ><router-link
            v-show="loginUserInfo"
            :loginUserInfo="this.loginUserInfo"
            :to="{ name: 'bookmark' }"
            >북마크</router-link
          ></b-nav-item
        >
      </b-nav>
      <router-view></router-view>
    </div>
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
