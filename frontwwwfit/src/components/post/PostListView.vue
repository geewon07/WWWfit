<template>
  <div>
    <h2></h2>
    <div class="container">
      <b-card-group columns>
        <b-card
          v-for="poster in posterfilter"
          :key="poster.posterSeq"
          :img-alt="poster.title"
          img-top
        >
          <post-list-item
            :poster="poster"
            :userLiked="userLiked(poster.posterSeq)"
            :loginUserInfo="loginUserInfo"
          ></post-list-item>
          <!-- <b-card-img
            @click="selectPoster(poster.posterSeq)"
            :style="{ objectFit: 'cover', objectPosition: 'top' }"
            :src="require(`@/assets/${poster.posterSrc}`)"
          /> -->

          <!-- <b-card-text
            class="small text-muted d-flex justify-content-between align-items-center"
          >
            <span>좋아요: {{ poster.likeCount }}</span>
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
          </b-card-text> -->
        </b-card>
      </b-card-group>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import PostListItem from "./PostListItem.vue";
export default {
  name: "PostListView",
  components: {
    PostListItem,
  },
  props: ["loginUserInfo", "select", "postList"],
  data() {
    return {
      selected: {},
    };
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
      const likePosterSeq = this.userLikes.map((liked) => liked.posterSeq);
      // for (let liked of this.userLikes) {
      //   if (liked.posterSeq == posterSeq) {
      //     return true;
      //   }
      // }
      // return false;
      return likePosterSeq.includes(posterSeq);
    },
    // like(posterSeq) {
    //   let like = {
    //     loginUser: this.loginUserInfo.userNo,
    //     posterSeq: posterSeq,
    //   };
    //   this.$store.dispatch("PostIndex/likePoster", like).then(() => {
    //     // Dispatch additional actions to refresh the data
    //     // this.$store.dispatch("PostIndex/getPosters");
    //     this.$store.dispatch(
    //       "PostIndex/getUserLikes",
    //       this.loginUserInfo.userNo
    //     );
    //     this.$forceUpdate();
    //   });
    // },
    // unlike(posterSeq) {
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
    // bookmark() {},
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
      poster: (state) => state.PostIndex.poster,
      // loginUserInfo: (state) => state.UserIndex.loginUserInfo,
    }),
    posterfilter() {
      if (this.select == null) {
        return this.postList;
      }
      if (this.select == "likes") {
        if (this.userLikes == null) {
          return [];
        }
        const likedPosters = this.userLikes.map((like) => like.posterSeq);

        return this.postList.filter((item) =>
          likedPosters.includes(item.posterSeq)
        );
      }
      return this.postList.filter((item) => item.fitPartName == this.select);
    },
  },

  // methods: {

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
