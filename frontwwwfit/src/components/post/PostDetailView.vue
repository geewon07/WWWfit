<template>
  <div>
    <!-- <h2>포스트 디테일 뷰! 선택하면 커지게?</h2>
    <b-button v-b-toggle.collapse-detail> X </b-button>
    <b-collapse visible id="collapse-detail"> -->
      <!-- <div> -->
<post-detail-content :selected="poster" :loginUserInfo="loginUserInfo" :getAverage="getAverage"></post-detail-content>
      </div>
    <!-- </b-collapse> -->
  <!-- </div> -->
</template>

<script>
import { mapState } from "vuex";
import PostDetailContent from './PostDetailContent.vue';
export default {
  components: { PostDetailContent },
  name: "PostDetailView",
  // props: {
  //   // selected: Object,
  //   // loginUserInfo: Object,
  // },
  // data() {
  //   return {
  //     score: 0,
  //     comment: "",
  //     average: 0,
  //   };
  // },
  // methods: {
  //   printposter() {
  //     console.log();
  //   },
  //   rate() {
  //     let rating = {
  //       userNo: this.loginUserInfo.userNo,
  //       review: this.comment,
  //       score: this.score,
  //       contentSeq: this.selected.posterSeq,
  //     };
  //     console.log(rating);
  //     this.$store.dispatch("PostIndex/ratePoster", rating);
  //   },
  //   getAVG() {
  //     this.average = this.$store.dispatch(
  //       "PostIndex/getRating",
  //       this.selected.posterSeq
  //     );
  //   },
  // },
  // created() {
  //   this.getAVG();
  // },
  computed: {
    ...mapState({
      getAverage: (state) => state.PostIndex.contentAVG,
      poster:(state)=> state.PostIndex.poster,
      loginUserInfo:(state)=>state.UserIndex.loginUserInfo,
    }),
  },
};
</script>

<style></style>
