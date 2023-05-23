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

  <b-card title="Card Title" no-body>
    <!-- <search-bar :loginUserInfo="this.loginUserInfo"></search-bar> -->
        <b-card-header header-tag="nav">
      <b-nav card-header pills>
        <!-- <b-nav-item>'s with child routes. Note the trailing slash on the first <b-nav-item> -->
        <b-nav-item to="/"  :videos="this.videos"
          :loginUserInfo="loginUserInfo" exact exact-active-class="active">동영상검색 결과</b-nav-item>
        <b-nav-item to="/bookmark" v-show="loginUserInfo"
            :loginUserInfo="loginUserInfo" exact exact-active-class="active">북마크</b-nav-item>
        <b-nav-form class="ml-auto">
        <b-form-input
          v-model="keyword"
          size="lg"
          class="mr-lg-2"
          placeholder="Search"
        ></b-form-input>
        <b-button size="lg" class="my-2 my-sm" @click="search">Search</b-button>
      </b-nav-form>
      </b-nav>
    </b-card-header>
     <b-card-body>
      <router-view></router-view>
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
  data(){
    return{
      keyword:"",
    };
  },
  computed: {
    ...mapState({
      loginUserInfo: (state) => state.UserIndex.loginUserInfo,
      videos:(state)=> state.SearchIndex.videos,

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
    search() {
      //  this.$store.dispatch("PostIndex/search","사무실 운동");
    },
  },
};
</script>

<style></style>
