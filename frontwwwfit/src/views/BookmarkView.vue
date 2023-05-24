<template>
  <div>
    <b-card no-body>
      <b-tabs pills card vertical>
        <b-tab
          :title="folder"
          width="20px"
          v-for="(folder, index) in bfolders"
          :key="index"
        >
          <b-card-text>
            <bookmark-folder-view
              :bookmarks="bookmarks"
              :folder="folder"
            ></bookmark-folder-view>
          </b-card-text>
        </b-tab>
      </b-tabs>
    </b-card>
    <!-- <div class="container-fluid">
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
    </div> -->
  </div>
</template>

<script>
import BookmarkFolderView from "@/components/bookmark/BookmarkFolderView.vue";
import { mapState } from "vuex";
export default {
  components: { BookmarkFolderView },
  name: "BookmarkView",
  created() {
    this.$store.dispatch("SearchIndex/getFolders", this.loginUserInfo.userNo);
    this.$store.dispatch("SearchIndex/getBookmarks", this.loginUserInfo.userNo);
  },
  computed: {
    ...mapState({
      loginUserInfo: (state) => state.UserIndex.loginUserInfo,
      bfolders: (state) => state.SearchIndex.bfolders,
      bookmarks: (state) => state.SearchIndex.bookmarks,
    }),
  },
};
</script>

<style></style>
