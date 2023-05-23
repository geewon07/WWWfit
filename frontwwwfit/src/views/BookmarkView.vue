<template>
  <div>
    <h1>
      북마크 뷰 가운데 분할해서 카드? 에서 옆에 선택하면 오른편 값이 바뀌게
      만들거야
    </h1>

    <b-card no-body>
      <b-tabs pills card vertical>
        <b-tab title="Tab 1" active>
          <b-card-text>
            <bookmark-folder-view></bookmark-folder-view>
          </b-card-text>
        </b-tab>
        <b-tab title="Tab 2"><b-card-text>Tab contents 2</b-card-text></b-tab>
        <b-tab title="Tab 3"><b-card-text>Tab contents 3</b-card-text></b-tab>
      </b-tabs>
    </b-card>
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-6">
          <div v-for="bookmark in bookmarks" :key="bookmark.id">
            <p>{{ bookmark.posterSeq }} but in real it's youtubeid</p>
            <p>
              {{ bookmark.bname }} could be something but also could be default
            </p>
            <p>
              {{ bookmark.regDate }}
            </p>
          </div>
        </div>
        <div class="col-md-6"></div>
      </div>
    </div>
  </div>
</template>

<script>
import BookmarkFolderView from "@/components/bookmark/BookmarkFolderView.vue";
import { mapState } from "vuex";
export default {
  components: { BookmarkFolderView },
  name: "BookmarkView",
  created() {
    this.$store.dispatch("SearchIndex/getFolders");
    this.$store.dispatch("SearchIndex/getBookmarks");
  },
  computed: {
    ...mapState({
      bfolders: (state) => state.SearchIndex.bfolders,
      bookmarks: (state) => state.SearchIndex.bookmarks,
    }),
  },
};
</script>

<style></style>
