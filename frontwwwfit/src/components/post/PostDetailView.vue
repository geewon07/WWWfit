<template>
  <div>
    <h2>포스트 디테일 뷰! 선택하면 커지게?</h2>
    <b-button v-b-toggle.collapse-detail> X </b-button>
    <b-collapse visible id="collapse-detail">
      <div>
        <b-card
          no-body
          style="max-width: auto"
          :img-src="require(`@/assets/${selected.posterSrc}`)"
          img-alt="Image"
          img-top
        >
          <template #header>
            <h4 class="mb-0">{{ selected.title }}</h4>
          </template>

          <b-card-body>
            <b-card-title>Card Title </b-card-title>
            <b-card-sub-title class="mb-2"
              >평점:{{ getAverage }}</b-card-sub-title
            >
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
                <b-button type="submit" @click.prevent="rate">등록</b-button>
              </b-form>
            </b-card-text>
          </b-card-body>

          <b-list-group flush>
            <b-list-group-item>{{ selected.fitPartName }}</b-list-group-item>
            <b-list-group-item>Dapibus ac facilisis in</b-list-group-item>
            <b-list-group-item>Vestibulum at eros</b-list-group-item>
          </b-list-group>

          <b-card-body>
            <a href="#" class="card-link">Card link</a>
            <a href="#" class="card-link">Another link</a>
          </b-card-body>

          <b-card-footer>This is a footer</b-card-footer>

          <b-card-img
            :src="require(`@/assets/darebee.png`)"
            alt="Image"
            bottom
          ></b-card-img>
        </b-card>
      </div>
    </b-collapse>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "PostDetailView",
  props: {
    selected: Object,
    loginUserInfo: Object,
  },
  data() {
    return {
      score: 0,
      comment: "",
      average: 0,
    };
  },
  // watch:{
  //   selected(newVal){

  //   }
  // },
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
    },
    getAVG() {
      this.average = this.$store.dispatch(
        "PostIndex/getRating",
        this.selected.posterSeq
      );
    },
  },
  created() {
    // const Average = this.$store.dispatch(
    //   "PostIndex/getRating",
    //   this.selected.posterSeq
    // );
    this.getAVG();
  },
  computed: {
    ...mapState({
      getAverage: (state) => state.PostIndex.contentAVG,
    }),
    // getAVG() {
    //   // this.average =
    //   return this.$store.dispatch(
    //     "PostIndex/getRating",
    //     this.selected.posterSeq
    //   );
    // },
  },
};
</script>

<style></style>
