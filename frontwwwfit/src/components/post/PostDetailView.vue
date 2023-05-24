<template>
  <div>
    <!-- <h2>포스트 디테일 뷰! 선택하면 커지게?</h2>
    <b-button v-b-toggle.collapse-detail> X </b-button>
    <b-collapse visible id="collapse-detail"> -->
    <!-- <div> -->
    <post-detail-content
      :selected="poster"
      :loginUserInfo="loginUserInfo"
      :getAverage="getAverage"
      :ratings="ratings"
      :todaydone="todaydone"
    ></post-detail-content>
  </div>
  <!-- </b-collapse> -->
  <!-- </div> -->
</template>

<script>
import { mapState } from "vuex";
import PostDetailContent from "@/components/post/PostDetailContent.vue";
export default {
  components: { PostDetailContent },
  name: "PostDetailView",
  props: ["loginUserInfo"],
  created() {
    this.$store.dispatch(
      "PostIndex/selectPoster",
      this.$route.params.posterSeq
    );
    this.$store.dispatch("PostIndex/getAVG", this.$route.params.posterSeq);
    this.$store.dispatch("PostIndex/getRatings", this.$route.params.posterSeq);
    //여기까지 받아오기!! 선택한 포스터, 평점- 리뷰 목록
    // 오운완 조회
    const currentDate = new Date();
    const year = currentDate.getFullYear();
    const month = String(currentDate.getMonth() + 1).padStart(2, "0");
    const day = String(currentDate.getDate()).padStart(2, "0");

    const formattedDate = `${year}-${month}-${day}`;
    console.log(formattedDate);

    let calendar = {
      calendarStart: formattedDate,
      userNo: this.loginUserInfo.userNo,
    };
    this.$store.dispatch("MypageIndex/todaycheck", calendar);
    console.log("todaydone:" + this.todaydone);
  },

  computed: {
    ...mapState({
      getAverage: (state) => state.PostIndex.contentAVG,
      poster: (state) => state.PostIndex.poster,
      loginUserInfo: (state) => state.UserIndex.loginUserInfo,
      ratings: (state) => state.PostIndex.ratings,
      todaydone: (state) => state.MypageIndex.todaydone,
    }),
  },
};
</script>

<style></style>
