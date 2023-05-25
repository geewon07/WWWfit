<template>
  <div>
    <!-- <h2>SEARCH RESULT placeholder</h2> -->
    <div class="album py-5 bg-light">
      <div class="container" v-if="videos.length != 0">
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
          <div
            v-for="(video, index) in videos"
            :key="video.id.videoId"
            class="col"
          >
            <!-- <div class="col"> -->
            <div class="card mb-4 box-shadow">
              <img
                class="card-img-top"
                style="object-fit: cover"
                :src="video.snippet.thumbnails.high.url"
                data-holder-rendered="true"
              />
              <div class="card-body">
                <p class="card-text">{{ video.snippet.title }}</p>
                <div class="d-flex justify-content-between align-items-center">
                  <div class="btn-group">
                    <b-button
                      v-b-modal="`${index}`"
                      type="button"
                      class="btn btn-sm btn-outline"
                    >
                      자세히
                    </b-button>

                    <b-modal
                      :id="`${index}`"
                      :title="video.snippet.title"
                      size="xl"
                      @ok="doBookmark(video.id.videoId, video.snippet.title)"
                    >
                      <div class="row">
                        <div class="col">
                          <iframe
                            width="560"
                            height="315"
                            :src="`https://www.youtube.com/embed/${video.id.videoId}`"
                            title="YouTube video player"
                            frameborder="0"
                            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                            allowfullscreen
                          ></iframe>
                        </div>

                        <div class="col">
                          <p>
                            {{ video.snippet.description }}
                          </p>
                          폴더 이름(미지정시 기본폴더에 저장됩니다):
                          <b-input type="text" v-model="bName"> </b-input>
                          북마크 설명(미지정시 동영상 제목이 저장됩니다, 100자)
                          <b-input
                            type="text"
                            v-model="description"
                            :placeholder="video.snippet.title"
                          ></b-input>
                        </div>
                      </div>
                    </b-modal>

                    <button
                      type="button"
                      class="btn btn-sm btn-outline-secondary"
                      @click="bmpopup(video.id.videoId, video.snippet.title)"
                    >
                      북마크
                    </button>
                  </div>
                  <small class="text-muted"> </small>
                </div>
              </div>
            </div>
            <!-- </div> -->
          </div>
        </div>
      </div>
      <div v-else>
        <h4>스트레칭할 부위 등을 검색하세요</h4>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "SearchResult",
  props: ["videos", "loginUserInfo"],
  data() {
    return {
      bName: "default",
      description: "",
    };
  },
  methods: {
    bmpopup(videoId, title) {
      if (window.confirm("기본 폴더에 북마크를 저장하시겠습니까")) {
        this.description = title;
        this.doBookmark(videoId);
      }
    },
    doBookmark(videoId, title) {
      console.log("detail bookmark");
      let desctext = this.description;
      if (this.description == "") {
        desctext = title;
      }
      let bookmark = {
        bName: this.bName,
        description: desctext.slice(0, 80),
        posterSeq: videoId,
        userNo: this.loginUserInfo.userNo,
      };
      console.log(bookmark);
      this.$store.dispatch("SearchIndex/createBookmark", bookmark);
    },
  },
  computed: {
    ...mapState({
      // videos: (state) => state.PostIndex.videos,
      // loginUserInfo: (state) => state.UserIndex.loginUserInfo,
    }),
  },
};
</script>

<style></style>
