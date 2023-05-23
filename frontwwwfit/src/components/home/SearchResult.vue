<template>
  <div>
    <h2>SEARCH RESULT placeholder</h2>
    <div class="album py-5 bg-light">
      <div class="container">
        카드컨테이너
        <div class="row">
          <div class="col-md-4">
            <div class="card mb-4 shadow-sm">
              <svg
                class="bd-placeholder-img card-img-top"
                width="100%"
                height="225"
                xmlns="http://www.w3.org/2000/svg"
                role="img"
                aria-label="Placeholder: Thumbnail"
                preserveAspectRatio="xMidYMid slice"
                focusable="false"
              >
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#55595c"></rect>
                <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
              </svg>

              <div class="card-body">
                <p class="card-text">
                  This is a wider card with supporting text below as a natural
                  lead-in to additional content. This content is a little bit
                  longer.
                </p>
                <div class="d-flex justify-content-between align-items-center">
                  <div class="btn-group">
                   <button
                      v-b-modal.modal-2
                      type="button"
                      class="btn btn-sm btn-outline-secondary"
                    >
                      자세히
                    </button>
                    <b-modal id="modal-2" title="BootstrapVue">
                      <p class="my-4">
                        !!!!!!! 여기에 ifram player 북마크 버튼,
                        userLoginInfo.userNo dispatch
                      </p>
                    </b-modal>
                    <button
                      type="button"
                      class="btn btn-sm btn-outline-secondary"
                    >
                      북마크
                    </button>
                  </div>
                  <small class="text-muted">
                    작은 글씨는 뭐를 나타내면 좋을까?</small
                  >

                </div>
              </div>
            </div>
          </div>

          <div v-if="videos">
            <div
              class="col-md-3"
              v-for="(video,index) in videos"
              :key="video.id.videoId"
            >
              <div class="card mb-4 box-shadow">
                <img
                  class="card-img-top"
                  style="object-fit: cover"
                  :src="video.snippet.thumbnails.high.url"
                  data-holder-rendered="true"
                />
                <div class="card-body">
                  <p class="card-text">{{ video.snippet.title }}</p>
                  <div
                    class="d-flex justify-content-between align-items-center"
                  >
                    <div class="btn-group">
                      <button
                       :v-b-modal="'modal-'+index"
                        type="button"
                        class="btn btn-sm btn-outline-secondary"
                      >
                        자세히
                      </button>
                      <b-modal :id="'modal-'+index" title="video.snippet.title">
                      <p class="my-4">


<iframe width="560" height="315" :src="`https://www.youtube.com/embed/${video.id.videoId}`" 
title="YouTube video player" frameborder="0" 
allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
allowfullscreen></iframe>

                        !!!!!!! 여기에 ifram player 북마크 버튼,
                        userLoginInfo.userNo dispatch
                      </p>
                    </b-modal>
                      <button
                        type="button"
                        class="btn btn-sm btn-outline-secondary"
                      >
                        북마크
                      </button>
                    </div>
                    <small class="text-muted">
                      작은 글씨는 뭐를 나타내면 좋을까?</small
                    >
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="col-md-3">
            <div class="card mb-4 box-shadow">
              <img
                class="card-img-top"
                style="object-fit: cover"
                img-src="http://i.ytimg.com/vi/DwTqs4IHwbs/maxresdefault.jpg"
                data-holder-rendered="true"
              />
              <div class="card-body">
                <p class="card-text">영상제목</p>
                <div class="d-flex justify-content-between align-items-center">
                  <div class="btn-group">
                    <button
                      v-b-modal.modal-1
                      type="button"
                      class="btn btn-sm btn-outline-secondary"
                    >
                      자세히
                    </button>
                    <b-modal id="modal-1" size="lg" style="min-width:600px" title="BootstrapVue">
                      <p class="my-4">
                        !!!!!!! 여기에 ifram player 북마크 버튼,
                        userLoginInfo.userNo dispatch

                        <iframe width="560" height="315" :src="`https://www.youtube.com/embed/wcIf3huwFhc`" 
title="YouTube video player" frameborder="0" 
allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
allowfullscreen></iframe>
                      </p>
                    </b-modal>
                    <button
                      type="button"
                      class="btn btn-sm btn-outline-secondary"
                    >
                      북마크
                    </button>
                  </div>
                  <small class="text-muted">
                    작은 글씨는 뭐를 나타내면 좋을까?</small
                  >
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "SearchResult",
  data() {
    return {};
  },
  computed: {
    ...mapState({
      videos: (state) => state.PostIndex.videos,
    }),
  },
};
</script>

<style></style>
