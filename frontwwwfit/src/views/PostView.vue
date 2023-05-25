<template>
  <div>
    <!-- <h2>포스트 뷰!!</h2> -->
    <b-container>
      <b-row>
        <b-col>
          <b-button
            variant="outline-danger"
            class="align-middle"
            @click.prevent="selectLike"
          >
            좋아요<b-icon icon="heart"></b-icon>
          </b-button>
        </b-col>
        <b-col cols="8"
          ><b-form-select v-model="select" :options="options"> </b-form-select
        ></b-col>
      </b-row>
    </b-container>

    <post-list-view
      :postList="postList"
      :loginUserInfo="loginUserInfo"
      :select="select"
    ></post-list-view>
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
  components: { PostListView },
  name: "PostView",
  props: ["userLikes"],
  data() {
    return {
      select: null,
      options: [
        { value: null, text: "전체" },
        { value: "eye", text: "눈" },
        { value: "neck", text: "목" },
        { value: "shoulder", text: "어깨" },
        { value: "hand", text: "손" },
        { value: "back", text: "허리" },
        { value: "leg", text: "다리" },
      ],
    };
  },
  methods: {
    selectLike() {
      if (this.loginUserInfo) {
        this.$store.dispatch(
          "PostIndex/getUserLikes",
          this.loginUserInfo.userNo
        );
      }
      this.$store.dispatch("PostIndex/getPosters");
      if (this.select != "likes") {
        this.select = "likes";
      } else if (this.select == "likes") {
        this.select = null;
      }
    },
  },
  // props: ["loginUserInfo"],
  created() {
    this.$store.dispatch("PostIndex/getPosters");
    console.log(this.loginUserInfo);
    if (this.loginUserInfo) {
      this.$store.dispatch("PostIndex/getUserLikes", this.loginUserInfo.userNo);
    }
    console.log(this.postList);
  },
  computed: {
    ...mapState({
      loginUserInfo: (state) => state.UserIndex.loginUserInfo,
      postList: (state) => state.PostIndex.postList,
      poster: (state) => state.PostIndex.poster,
      // userLikes: (state) => state.PostIndex.userLikes,
    }),
    // posterfilter() {
    //   if (this.select == null) {
    //     return this.postList;
    //   }
    //   return this.postList.filter((item) => item.fitPartName == this.select);
    // },
  },
};
</script>

<style scoped>
.align-middle {
  vertical-align: middle;
}
</style>
