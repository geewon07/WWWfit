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
            <b-card-title>Card Title</b-card-title>
            <b-card-sub-title class="mb-2">Card Sub Title</b-card-sub-title>
            <b-card-text>
              <b-form>
                <label for="rating-inline">평점:</label>
                <b-form-rating
                  id="rating-inline"
                  inline
                  value="0"
                ></b-form-rating>
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
export default {
  name: "PostDetailView",
  props: ["selected"],
  methods: {
    printposter() {
      console.log();
    },
  },
};
</script>

<style></style>
