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
          <b-card-title>
            # {{ selected.posterSeq }}, {{ selected.fitPartName }}
          </b-card-title>

          <post-detail-rating
            :selected="selected"
            :loginUserInfo="loginUserInfo"
            :getAverage="getAverage"
          ></post-detail-rating>
        </b-card-body>

        <b-list-group
          flush
          v-for="(rating, index) in contentfilter"
          :key="index"
        >
          <b-list-group-item
            ><!-- 이 사이에 버튼 달고 자기 자신 거면 삭제 수정 가능하게-->
            <b-form-rating
              :value="rating.score"
              readonly
              inline
              show-value
              precision="1"
            >
            </b-form-rating>
            {{ rating.userNo }}무기명 고?|{{ rating.review }} 수정 삭제
            추가?|<span id="date_font" class="text-right"
              >{{ rating.regDate }}<button></button
            ></span>
          </b-list-group-item>
        </b-list-group>

        <b-card-body>
          <router-link :to="{ name: 'plist' }" class="card-link">
            목록으로
          </router-link>
          <a
            :href="`https://darebee.com/workouts/${address}`"
            class="card-link"
          >
            DAREBEE
          </a>
        </b-card-body>

        <b-card-footer v-if="this.loginUserInfo">
          <b-button
            variant="success"
            v-if="!todaydone"
            type="submit"
            @click="todaychallenge(selected.fitPartName)"
          >
            오늘의 운동 완료 체크!
          </b-button>
          <b-button disabled v-else variant="outline-success">
            오늘의 운동을 완료했습니다
          </b-button>
        </b-card-footer>

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
// import { mapState } from "vuex";
import PostDetailRating from "./PostDetailRating.vue";
export default {
  components: { PostDetailRating },
  name: "PostDetailContent",
  props: ["selected", "loginUserInfo", "getAverage", "ratings", "todaydone"],
  methods: {
    todaychallenge(fitPartName) {
      const currentDate = new Date();
      const year = currentDate.getFullYear();
      const month = String(currentDate.getMonth() + 1).padStart(2, "0");
      const day = String(currentDate.getDate()).padStart(2, "0");

      const formattedDate = `${year}-${month}-${day}`;
      console.log(formattedDate);
      let calendar = {
        calendarStart: formattedDate,
        fitPartName: fitPartName,
        userNo: this.loginUserInfo.userNo,
      };

      this.$store.dispatch("MypageIndex/challengeDone", calendar);
      // this.$router.push({
      //   name: "detail",
      //   params: { posterSeq: this.selected.posterSeq },
      // });
      this.$router.go(0);
    },
  },
  computed: {
    // ...mapState("PostIndex", ["ratings"]),
    address() {
      let mod = this.selected.posterSrc.replace(".jpg", ".html");
      console.log(mod);
      return mod;
    },
    contentfilter() {
      return this.ratings.filter(
        (item) => item.contentSeq === this.selected.posterSeq
      );
    },
  },
  // data() {
  //   return {
  //     address: this.selected.posterSrc.replace(".jpg", ".html"),
  //   };
  // },
};
</script>

<style scoped>
#date_font {
  font-size: 14px;
  color: hsl(224, 95%, 58%);
}
</style>
