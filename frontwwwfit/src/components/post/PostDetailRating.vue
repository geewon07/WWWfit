<template>
  <div>
    <b-card-sub-title class="mb-2">평점:{{ getAverage }}</b-card-sub-title>
    <b-card-text>
      <b-form class="d-flex flex-row">
        <!-- <label for="rating-inline">평점:</label> -->
        <b-form-rating
          id="rating-inline"
          inline
          value="0"
          v-model="score"
        ></b-form-rating>
        <!-- <label for="rating">평가</label>        class="mr-lg-2"-->
        <b-form-input
          type="text"
          v-model="comment"
          placeholder="코멘트 입력해도 되고 안해도 됨"
        ></b-form-input>
        <b-button type="submit" @click="rate">등록</b-button>
      </b-form>
    </b-card-text>
  </div>
</template>

<script>
// import { mapState } from "vuex";
export default {
  name: "PostDetailRating",
  props: ["selected", "loginUserInfo", "getAverage"],
  data() {
    return {
      score: 0,
      comment: "",
      average: 0,
    };
  },
  created() {
    // this.$store.dispatch("PostIndex/getAVG", this.selected.posterSeq);
    // this.$store.dispatch("PostIndex/getRatings", this.selected.posterSeq);
  },

  methods: {
    printposter() {
      console.log();
    },
    rate() {
      let rating = {
        userNo: this.loginUserInfo.userNo,
        review: this.comment,
        score: this.score,
        contentSeq: this.selected.posterSeq,
      };
      console.log(rating);
      this.$store.dispatch("PostIndex/ratePoster", rating);
      this.$store.dispatch("PostIndex/getAVG", this.selected.posterSeq);
      this.$router.push({
        name: "detail",
        params: { posterSeq: this.selected.posterSeq },
      });
    },
  },
  computed: {
    // ...mapState("PostIndex/contentAVG"),
    // ...mapState("PostIndex/"),
  },
};
</script>

<style></style>
