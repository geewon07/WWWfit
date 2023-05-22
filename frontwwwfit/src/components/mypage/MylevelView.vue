<template>
  <div class="mylevel-container">
    <div class="row align-items-center justify-content-center">
      <div class="col-md-1 text-right">
        <img
          :src="getRankIcon(mypageinfo.userRank)"
          alt="Rank Icon"
          width="50px"
          height="50px"
        />
      </div>
      <div class="col-md-1">
        <p class="name">{{ mypageinfo.name }}님</p>
      </div>
      <div class="col-md-2 text-right">
        <p class="ex">보유 경험치 {{ mypageinfo.experience }}</p>
      </div>
      <div class="col-md-5">
        <div class="d-flex justify-content-between">
          <div>{{ getStartValue(mypageinfo.userRank) }}</div>
          <div class="ml-auto">{{ getEndValue(mypageinfo.userRank) }}</div>
        </div>
        <div class="progress">
          <div
            class="progress-bar"
            role="progressbar"
            :style="{ width: getExperiencePercentage() }"
            :class="getExperienceClass(mypageinfo.experience)"
            :aria-valuemin="getStartValue(mypageinfo.userRank)"
            :aria-valuemax="getEndValue(mypageinfo.userRank)"
            :aria-valuenow="
              mypageinfo.experience - getStartValue(mypageinfo.userRank)
            "
          >
            {{ getExperiencePercentage() }}
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <!-- Display the number of consecutive workout days -->
        <p class="ex">연속 {{ mypageinfo.challengedays }}일 운동 완료!</p>
      </div>
    </div>
  </div>
</template>

<script>
// 경험치, 연속 횟수, 이름,
// 연속일 수 count할 수 있는 값
import { mapState } from "vuex";
export default {
  props: ["loginUserInfo"],
  computed: {
    ...mapState({
      mypageinfo: (state) => state.MypageIndex.mypageinfo,
    }),
  },
  created() {
    this.$store.dispatch("MypageIndex/getMypage", this.loginUserInfo.userNo);
  },
  methods: {
    getRankIcon(rank) {
      // Implement logic to return the appropriate rank icon based on userRank
      // Example:
      if (rank === "VIP") {
        return require("@/assets/level/vip.png");
      } else if (rank === "Gold") {
        return require("@/assets/level/gold.png");
      } else if (rank === "Silver") {
        return require("@/assets/level/sliver.png");
      } else if (rank === "Bronze") {
        return require("@/assets/level/bronze.png");
      } else {
        return require("@/assets/level/green.png");
      }
    },
    getExperiencePercentage() {
      const startValue = this.getStartValue(this.mypageinfo.userRank);
      const endValue = this.getEndValue(this.mypageinfo.userRank);
      const currentExp = this.mypageinfo.experience - startValue;
      const percentage = ((currentExp / (endValue - startValue)) * 100).toFixed(
        2
      );
      return `${percentage}%`;
    },
    getExperienceClass(experience) {
      // Implement logic to return the Bootstrap class based on user's experience
      // Example:
      if (experience < 10 && experience >= 0) {
        return "bg-success"; // Green
      } else if (experience < 20) {
        return "bg-secondary"; // Bronze
      } else if (experience < 40) {
        return "bg-info"; // Silver
      } else if (experience < 60) {
        return "bg-warning"; // Gold
      } else if (experience > 80) {
        return "bg-danger"; // VIP
      } else {
        return ""; // Default class (no background color)
      }
    },
    getStartValue(rank) {
      // Implement logic to return the start value of the given rank
      // Example:
      if (rank === "Green") {
        return 0;
      } else if (rank === "Bronze") {
        return 10;
      } else if (rank === "Silver") {
        return 20;
      } else if (rank === "Gold") {
        return 40;
      } else {
        return 60;
      }
    },
    getEndValue(rank) {
      // Implement logic to return the end value of the given rank
      // Example:
      if (rank === "Green") {
        return 10;
      } else if (rank === "Bronze") {
        return 20;
      } else if (rank === "Silver") {
        return 40;
      } else if (rank === "Gold") {
        return 60;
      } else {
        return 100;
      }
    },
  },
};
</script>

<style scoped>
.mylevel-container {
  background-color: #f8f8f8;
  border: 2px solid #ccc;
  border-radius: 4px;
  padding: 20px;
}

.name {
  font-size: 30px;
}

.ex {
  font-size: 25px;
}
</style>
