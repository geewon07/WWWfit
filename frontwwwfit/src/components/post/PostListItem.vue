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
      <span>좋아요: {{ likenum }}</span>
      <b-button v-if="loginUserInfo" pill variant="outline-danger">
        <b-icon
          v-show="userLiked(poster.posterSeq)"
          icon="heart-fill"
          @click="unlike(poster.posterSeq)"
        />
        <b-icon
          v-show="!userLiked(poster.posterSeq)"
          icon="heart"
          @click="like(poster.posterSeq)"
        />
      </b-button>
    </b-card-text>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "PostListItem",
  props: ["poster", "userLikes"],
  data() {
    return {
      //   ifliked: this.userLiked(poster),
      likenum: this.poster.likeCount,
    };
  },
  computed: {
    ...mapState({
      loginUserInfo: (state) => state.UserIndex.loginUserInfo,
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
    userLiked(posterSeq) {
      if (this.userLikes == null) {
        return false;
      }
      //   const likedPosters = userLikes.filter(item=> userLikes.posterSeq)
      const likePosterSeq = this.userLikes.map((liked) => liked.posterSeq);

      return likePosterSeq.includes(posterSeq);
    },
    like(posterSeq) {
      this.likenum += 1;
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
        this.$forceUpdate();
      });
    },
    unlike(posterSeq) {
      this.likenum -= 1;
      let like = {
        loginUser: this.loginUserInfo.userNo,
        posterSeq: posterSeq,
      };

      this.$store.dispatch("PostIndex/unlikePoster", like).then(() => {
        // Dispatch additional actions to refresh the data
        this.$forceUpdate();
        // this.$store.dispatch("PostIndex/getPosters");
        this.$store.dispatch(
          "PostIndex/getUserLikes",
          this.loginUserInfo.userNo
        );
        this.$forceUpdate();
      });
    },
  },
};
</script>

<style></style>
