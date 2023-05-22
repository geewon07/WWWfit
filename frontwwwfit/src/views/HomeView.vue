<template>
  <div @click="executeSearch">
    <div>
      <b-carousel
        id="carousel-1"
        :interval="4000"
        controls
        indicators
        background="#ababab"
        img-width="1024"
        img-height="480"
        style="text-shadow: 1px 1px 2px #333"
      >
        <!-- Text slides with image          v-model="slide"    @sliding-start="onSlideStart"
            @sliding-end="onSlideEnd"-->
        <b-carousel-slide
          caption="First slide"
          text="Nulla vitae elit libero, a pharetra augue mollis interdum."
          img-src="https://picsum.photos/1024/480/?image=52"
        ></b-carousel-slide>

        <!-- Slides with custom text -->
        <b-carousel-slide img-src="https://picsum.photos/1024/480/?image=54">
          <h1>Hello world!</h1>
        </b-carousel-slide>
      </b-carousel>
    </div>
    <!-- <post-list-view :loginUserInfo="loginUserInfo"></post-list-view> -->
    <search-bar :loginUserInfo="this.loginUserInfo"></search-bar>
    <!-- <post-view :loginUserInfo="this.loginUserInfo"></post-view> -->
    <search-result :loginUserInfo="loginUserInfo"></search-result>
    <!-- <post-list-view :loginUserInfo="loginUserInfo"></post-list-view> -->
  </div>
</template>

<script>
// import PostView from "@/views/PostView.vue";
import SearchResult from "@/components/home/SearchResult.vue";
import SearchBar from "../components/home/SearchBar.vue";
// import PostListView from "@/components/post/PostListView.vue";PostView,
import { mapState } from "vuex"; //v-if="getUser"PostListView , SearchResult
// import PostView from "@/views/PostView.vue";
export default {
  components: { SearchBar, SearchResult },
  name: "HomeView",
  computed: {
    ...mapState({
      loginUserInfo: (state) => state.UserIndex.loginUserInfo,
    }),
    // getUser() {
    //   if (this.loginUser) {
    //     return true;
    //   } else {
    //     return false;
    //   }
    // },
  },
  created() {
    // this.$refs.SearchBar.search();
    // this.$store.dispatch("PostIndex/search","사무실 운동");
  },
  methods: {
    executeSearch() {
      //  this.$store.dispatch("PostIndex/search","사무실 운동");
    },
  },
};
</script>

<style></style>
