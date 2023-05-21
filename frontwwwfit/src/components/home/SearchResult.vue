<template>
  <div>
  
    <h2>SEARCH RESULT placeholder</h2>
    <div class="album py-5 bg-light">
        <div class="container">
            카드컨테이너
          <div class="row">
            <div v-if="videos">
            <div class="col-md-3" v-for="(video) in videos" :key="video.id.videoId">
              <div class="card mb-4 box-shadow">
                <img class="card-img-top" style="object-fit:cover" :src="video.snippet.thumbnails.high.url" data-holder-rendered="true">
                <div class="card-body">
                  <p class="card-text">{{video.snippet.title}}</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                      <button v-b-modal.modal-1 type="button" class="btn btn-sm btn-outline-secondary">자세히</button>
                      <button type="button" class="btn btn-sm btn-outline-secondary">북마크</button>
                    </div>
                    <small class="text-muted"> 작은 글씨는 뭐를 나타내면 좋을까?</small>
                  </div>
                </div>
              </div>
            </div>
            </div>
            <div class="col-md-3" >
              <div class="card mb-4 box-shadow">
                <img class="card-img-top" style="object-fit:cover" img-src="http://i.ytimg.com/vi/DwTqs4IHwbs/maxresdefault.jpg" data-holder-rendered="true">
                <div class="card-body">
                  <p class="card-text">영상제목</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                      <button v-b-modal.modal-1 type="button" class="btn btn-sm btn-outline-secondary">자세히</button>
                      <b-modal id="modal-1" title="BootstrapVue">
                          <p class="my-4">Hello from modal!</p>
                        </b-modal>
                      <button type="button" class="btn btn-sm btn-outline-secondary">북마크</button>
                    </div>
                    <small class="text-muted"> 작은 글씨는 뭐를 나타내면 좋을까?</small>
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
import {mapState} from "vuex";
export default {
  name:"SearchResult",
  data(){
    return{};
  },
  computed:{
    ...mapState({
      videos:(state)=> state.PostIndex.videos,
    }),
  }
};
</script>

<style></style>
