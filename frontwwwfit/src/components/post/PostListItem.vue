<template>
  <div>
    <b-card-img
      @click="selectPoster(poster.posterSeq)"
      :style="{ objectFit: 'cover', objectPosition: 'top' }"
      :src="require(`@/assets/${poster.posterSrc}`)"
    />
    <!-- 난이도:{{ poster.difficulty }}  -->
    <b-card-text>
      <!-- <b-button v-show="loginUserInfo" pill variant="outline-secondary">
              <b-icon icon="bookmark" @click="bookmark"></b-icon>
            </b-button> -->
    </b-card-text>
    <b-card-text
      class="small text-muted d-flex justify-content-between align-items-center"
    >
      <span>좋아요: {{ poster.likeCount }}</span>
      <b-button
        v-if="loginUserInfo"
        pill
        variant="outline-danger"
        @click="like(poster.posterSeq)"
      >
        <b-icon v-show="ifliked" icon="heart-fill" />
        <b-icon v-show="!ifliked" icon="heart" />
      </b-button>
    </b-card-text>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "PostListItem",
  props: ["poster", "userLikes", "userLiked", "loginUserInfo"],
  data() {
    return {
      ifliked: this.userLiked, // true or false
      likenum: this.poster.likeCount,
    };
  },
  created() {
    this.ifliked = this.userLiked;
  },
  computed: {
    ...mapState({
      // loginUserInfo: (state) => state.UserIndex.loginUserInfo,
    }),
  },

  methods: {
    selectPoster(posterSeq) {
      this.$store.dispatch("PostIndex/selectPoster", posterSeq);
      this.$router.push({
        name: "detail",
        params: { posterSeq },
        props: { loginUserInfo: this.loginUserInfo }, // additional props
      });
    },
    // userLiked(posterSeq) {
    //   if (this.userLikes == null) {
    //     return false;
    //   }
    //   //   const likedPosters = userLikes.filter(item=> userLikes.posterSeq)
    //   const likePosterSeq = this.userLikes.map((liked) => liked.posterSeq);

    //   return likePosterSeq.includes(posterSeq);
    // },
    like(posterSeq) {
      if (this.ifliked) {
        //true ---> unlike
        this.likenum -= 1;
        this.ifliked = !this.ifliked;
        let like = {
          loginUser: this.loginUserInfo.userNo,
          posterSeq: posterSeq,
        };
        this.$store.dispatch("PostIndex/unlikePoster", like).then(() => {
          // Dispatch additional actions to refresh the data
          // this.$store.dispatch("PostIndex/getPosters");
          this.$store.dispatch(
            "PostIndex/getUserLikes",
            this.loginUserInfo.userNo
          );
          this.$store.dispatch("PostIndex/getPosters");
          // this.$forceUpdate();
          // this.$router.go(0);
        });
      } else {
        this.likenum += 1;
        this.ifliked = !this.ifliked;
        let like = {
          loginUser: this.loginUserInfo.userNo,
          posterSeq: posterSeq,
        };
        this.$store.dispatch("PostIndex/likePoster", like).then(() => {
          // Dispatch additional actions to refresh the data
          // this.$store.dispatch("PostIndex/getPosters");
          this.$store.dispatch(
            "PostIndex/getUserLikes",
            this.loginUserInfo.userNo
          );
          this.$store.dispatch("PostIndex/getPosters");
          // this.$forceUpdate();
          // this.$router.go(0);
        });
      }
      // .then(() => {
      // // Dispatch additional actions to refresh the data
      // // this.$store.dispatch("PostIndex/getPosters");
      // this.$store.dispatch("PostIndex/getUserLikes", this.loginUserInfo.userNo);
      // this.$store.dispatch("PostIndex/getPosters");
      // // this.$forceUpdate();
      // // this.$router.go(0);
      // });
    },
    // unlike(posterSeq) {
    //   this.likenum -= 1;
    //   let like = {
    //     loginUser: this.loginUserInfo.userNo,
    //     posterSeq: posterSeq,
    //   };

    //   this.$store.dispatch("PostIndex/unlikePoster", like).then(() => {
    //     // Dispatch additional actions to refresh the data
    //     this.$forceUpdate();
    //     // this.$store.dispatch("PostIndex/getPosters");
    //     this.$store.dispatch(
    //       "PostIndex/getUserLikes",
    //       this.loginUserInfo.userNo
    //     );
    //     this.$forceUpdate();
    //   });
    // },
  },
};
</script>

<style></style>
