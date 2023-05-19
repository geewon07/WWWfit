<template>
  <div>
    <h2>로그인시 포스트리스트뷰!</h2>
    <div class="container">
      <b-card
        v-for="poster in posterList"
        title="Title"
        :img-src="poster.postersrc"
        img-alt="Image"
        img-top
      >
        <b-card-text>
          This card has supporting text below as a natural lead-in to additional
          content.
        </b-card-text>
        <b-card-text class="small text-muted"
          >Last updated 3 mins ago</b-card-text
        >
      </b-card>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "PostListView",
  data() {
    return {
      slide: 0,
      sliding: null,
      text: " accordion",
      posterImg: require("@/assets/"),
    };
  },
  computed: {
    ...mapState({ postList: (state) => state.PostIndex.postList }),
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

<style></style>
