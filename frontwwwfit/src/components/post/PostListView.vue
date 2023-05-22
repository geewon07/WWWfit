<template>
  <div>
    <h2>홈화면 오픈시 포스트리스트뷰!</h2>
    <div class="container">
      <b-card-group>
      <b-card
        v-for="(poster,index) in postList"
        :key="index"
        :img-alt="poster.title"
        img-top
      >
           <!--        :title="poster.title" :img-src="require(`@/assets/${poster.posterSrc}`)" -->
      <b-card-img :style="{ objectFit: 'cover', objectPosition: 'top' }" :src="require(`@/assets/${poster.posterSrc}`)"/>
        <b-card-text>
          난이도:{{poster.difficulty}}
          좋아요:{{poster.likeCount}}
          <b-button v-if="loginUserInfo">
          <b-icon v-if="userLiked(poster.posterSeq)" icon="heart-fill" @click="unlike(poster.posterSeq)"/>
          <b-icon v-else icon="heart" @click="like(poster.posterSeq)" />
          </b-button>
        </b-card-text>
        <b-card-text class="small text-muted"
          >Last updated 3 mins ago</b-card-text
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
  props:[
    "loginUserInfo",
  ],
  data() {
    return {
      slide: 0,
      sliding: null,
      text: " accordion",
      likePosterSeq:"",
    };
  },
  methods:{
    userLiked(posterSeq){
      if(this.userLikes==null){
        return false;
      }
      for(let liked of this.userLikes){
        if(liked.posterSeq == posterSeq){
          return true;
        }
      }
      return false;
    },
    like(){
      this.$store.dispatch("PostIndex/likePoster");
    },
    unlike(){
      this.$store.dispatch("PostIndex/likePoster");
    }
  },
  created(){
    this.$store.dispatch("PostIndex/getPosters");
    console.log(this.loginUserInfo)
    if(this.loginUserInfo)
    this.$store.dispatch("PostIndex/getUserLikes",this.loginUserInfo.userNo);
  },
  computed: {
    ...mapState({ postList: (state) => state.PostIndex.postList ,
    userLikes:(state)=> state.PostIndex.userLikes,
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
}</style>
