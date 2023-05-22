<template>
  <div>
    <h2>홈화면 오픈시 포스트리스트뷰!</h2>
    <div class="container">
      <b-card-group columns>
        <b-card
          v-for="poster in postList"
          :key="poster.posterSeq"
          :img-alt="poster.title"
          img-top
        >
          <!--        :title="poster.title" :img-src="require(`@/assets/${poster.posterSrc}`)" -->
          <b-card-img
            @click="selectPoster(poster.posterSeq)"
            :style="{ objectFit: 'cover', objectPosition: 'top' }"
            :src="require(`@/assets/${poster.posterSrc}`)"
          />

          <!-- 난이도:{{ poster.difficulty }}  -->
          <b-card-text>
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
            <b-button v-show="loginUserInfo" pill variant="outline-secondary">
              <b-icon icon="bookmark" @click="bookmark"></b-icon>
            </b-button>
          </b-card-text>
          <b-card-text class="small text-muted">
            좋아요:{{ poster.likeCount }}</b-card-text
          >
        </b-card>
      </b-card-group>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "PostListView",
  props: ["loginUserInfo",],
  data() {
    return {
      slide: 0,
      sliding: null,
      text: " accordion",
      selected:{},
      // likePosterSeq: "",
    };
  },
  methods: {
    selectPoster(posterSeq) {
      this.$store.dispatch("PostIndex/selectPoster", posterSeq);
      this.$router.push({
        name: "detail",
        props: { loginUserInfo:this.loginUserInfo }, // additional props
      });
    },
    userLiked(posterSeq) {
      if (this.userLikes == null) {
        return false;
      }
      for (let liked of this.userLikes) {
        if (liked.posterSeq == posterSeq) {
          return true;
        }
      }
      return false;
    },
    like(posterSeq) {
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
    bookmark() {},
  },
  created() {
    this.$store.dispatch("PostIndex/getPosters");
    console.log(this.loginUserInfo);
    if (this.loginUserInfo) {
      this.$store.dispatch("PostIndex/getUserLikes", this.loginUserInfo.userNo);
    }
  },
  computed: {
    ...mapState({
      postList: (state) => state.PostIndex.postList,
      userLikes: (state) => state.PostIndex.userLikes,
      poster:(state)=> state.PostIndex.poster,
      loginUserInfo:(state)=>state.UserIndex.loginUserInfo,
    }),
  },

  // methods: {
  //   onSlideStart(slide) {
  //     this.sliding = true;
  //   },
  //   onSlideEnd(slide) {
  //     this.sliding = false;
  //   },
  // },
};
</script>

<style scoped>
.container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}

.custom-card {
  width: 200px;
  margin-bottom: 20px;
}

.b-card-image {
  object-fit: cover;
  object-position: top;
  height: 50%;
}
</style>
