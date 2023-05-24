<template>
  <div>
    <!-- <h2>insid the tab card, make an accordion?</h2> -->
    <div
      class="accordion"
      role="tablist"
      v-for="(bookmark, index) in bookmarks"
      :key="index"
    >
      <b-card no-body class="mb-1" v-if="bookmark.bname == folder">
        <b-card-header header-tag="header" class="p-1" role="tab">
          <b-button block v-b-toggle="`${index}`" variant="info">{{
            bookmark.description
          }}</b-button>
        </b-card-header>
        <b-collapse :id="`${index}`" accordion="my-accordion" role="tabpanel">
          <b-card-body>
            <b-card-text>
              <iframe
                width="560"
                height="315"
                :src="`https://www.youtube.com/embed/${bookmark.posterSeq}`"
                title="YouTube video player"
                frameborder="0"
                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                allowfullscreen
              ></iframe>
            </b-card-text>
            <b-card-text>{{ bookmark.regDate }}</b-card-text>
          </b-card-body>
        </b-collapse>
      </b-card>

      <!-- <b-card no-body class="mb-1">
        <b-card-header header-tag="header" class="p-1" role="tab">
          <b-button block v-b-toggle.accordion-2 variant="info"
            >Accordion 2</b-button
          >
        </b-card-header>
        <b-collapse id="accordion-2" accordion="my-accordion" role="tabpanel">
          <b-card-body>
            <b-card-text>{{ text }}</b-card-text>
          </b-card-body>
        </b-collapse>
      </b-card> -->
    </div>
  </div>
</template>

<script>
export default {
  name: "BookmarkFolderView",
  props: ["bookmarks", "folder"],
};
</script>

<style></style>
