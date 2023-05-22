<template>
  <div>
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
            <b-card-title>Card Title {{selected.posterSeq}} </b-card-title>

            <post-detail-rating :selected="selected" :loginUserInfo="loginUserInfo" :getAverage="getAverage"></post-detail-rating>


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
  </div>
</template>

<script>
import PostDetailRating from './PostDetailRating.vue';
export default {
  components: { PostDetailRating },
  name:"PostDetailContent",
  props:["selected","loginUserInfo","getAverage"],

};
</script>

<style></style>
