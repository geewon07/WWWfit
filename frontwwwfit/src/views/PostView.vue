<template>
  <div>
    <h2>포스트 뷰!!</h2>
    <!-- <post-detail-view
      :selected="poster"
      :loginUserInfo="loginUserInfo"
    ></post-detail-view> -->
    <post-list-view :loginUserInfo="loginUserInfo"></post-list-view>
    <!-- <router-link :to="{name:'detail'}" :selected="poster"
      :loginUserInfo="loginUserInfo">포스터 세부</router-link> -->
    <!-- <router-link :to="{name:'plist'}">포스터 리스트</router-link> -->
    <!-- <router-view ></router-view> -->
  </div>
</template>

<script>
import PostListView from "@/components/post/PostListView.vue";
// import SearchResult from "@/components/home/SearchResult.vue";
import { mapState } from "vuex";
// import PostDetailView from  PostDetailView "@/components/post/PostDetailView.vue";
export default {
  components: { PostListView,},
  name: "PostView",
  // props: ["loginUserInfo"],
  created() {
    this.$store.dispatch("PostIndex/getPosters");
    console.log(this.loginUserInfo);
    if (this.loginUserInfo) {
      this.$store.dispatch("PostIndex/getUserLikes", this.loginUserInfo.userNo);
    }
  },
  computed: {
    ...mapState({
      loginUserInfo: (state) => state.UserIndex.loginUserInfo,
      postList: (state) => state.PostIndex.postList,
      poster: (state) => state.PostIndex.poster,
      userLikes: (state) => state.PostIndex.userLikes,
    }),
  },
};
</script>

<style></style>
