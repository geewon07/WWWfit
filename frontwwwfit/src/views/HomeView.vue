<template>
  <div>
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
        <!-- Text slides with image             caption="First slide"
          text="Nulla vitae elit libero, a pharetra augue mollis interdum."  :img-src="require('@/assets/resize.jpg')"     v-model="slide"    @sliding-start="onSlideStart"
            @sliding-end="onSlideEnd"-->
        <b-carousel-slide
          :img-src="require('@/assets/resize.jpg')"
        ></b-carousel-slide>

        <!-- Slides with custom text -->
        <b-carousel-slide :img-src="require('@/assets/resize.jpg')">
          <h1>Hello world!</h1>
        </b-carousel-slide>

        <b-carousel-slide :img-src="require('@/assets/resize.jpg')">
          <h1>Hello world!</h1>
        </b-carousel-slide>

        <b-carousel-slide :img-src="require('@/assets/resize.jpg')">
          <h1>Hello world!</h1>
        </b-carousel-slide>
      </b-carousel>
    </div>

    <b-card title="Card Title" no-body>
      <!-- <search-bar :loginUserInfo="this.loginUserInfo"></search-bar> -->
      <b-card-header header-tag="nav">
        <b-nav card-header pills class="d-flex align-items-center">
          <!-- <b-nav-item>'s with child routes. Note the trailing slash on the first <b-nav-item> -->
          <b-nav-item to="/" exact exact-active-class="active"
            >동영상 검색</b-nav-item
          >
          <b-nav-item
            to="/bookmark"
            v-show="loginUserInfo"
            :loginUserInfo="loginUserInfo"
            exact
            exact-active-class="active"
            >북마크</b-nav-item
          >
          <b-nav-form class="ml-auto">
            <b-form-input
              v-model="keyword"
              size="lg"
              class="mr-lg-2"
              placeholder="Search"
              @keydown.enter.prevent="search"
            ></b-form-input>
            <b-button size="lg" class="my-2 my-sm" @click.prevent="search"
              >Search</b-button
            >
          </b-nav-form>
        </b-nav>
      </b-card-header>
      <b-card-body>
        <router-view
          :videos="videos"
          :loginUserInfo="loginUserInfo"
        ></router-view>
      </b-card-body>
    </b-card>
  </div>
</template>

<script>
// import SearchResult from "@/components/home/SearchResult.vue";//, SearchResult
// import SearchBar from "../components/home/SearchBar.vue";
import { mapState } from "vuex"; //v-if="getUser"PostListView , SearchResult

export default {
  // components: { SearchBar },
  name: "HomeView",
  data() {
    return {
      keyword: "",
    };
  },
  computed: {
    ...mapState({
      loginUserInfo: (state) => state.UserIndex.loginUserInfo,
      videos: (state) => state.SearchIndex.videos,
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
    if (this.loginUserInfo) {
      this.$store.dispatch(
        "SearchIndex/getBookmarks",
        this.loginUserInfo.userNo
      );
      this.$store.dispatch("SearchIndex/getFolders", this.loginUserInfo.userNo);
    }
  },
  methods: {
    search() {
      this.$store.dispatch("SearchIndex/search", "사무실 운동" + this.keyword);
    },
  },
};
</script>

<style></style>
