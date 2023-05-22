<template>
  <div class="mylevel-container">
    <p class="title">보유 뱃지</p>
    <div class="badge-container">
      <div class="badge-item">
        <p>neck</p>
        <div class="badge-images">
          <div class="badge-image" v-if="checkBadge('neck', 5)">
            <img
              v-if="checkBadge('neck', 5)"
              :src="getBadgeImage('count5')"
              :alt="getBadgeAltText('neck_count5')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('neck', 10)">
            <img
              v-if="checkBadge('neck', 10)"
              :src="getBadgeImage('count10')"
              :alt="getBadgeAltText('neck_count10')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('neck', 20)">
            <img
              v-if="checkBadge('neck', 20)"
              :src="getBadgeImage('count20')"
              :alt="getBadgeAltText('neck_count20')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('neck', 50)">
            <img
              v-if="checkBadge('neck', 50)"
              :src="getBadgeImage('count50')"
              :alt="getBadgeAltText('neck_count50')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('neck', 100)">
            <img
              v-if="checkBadge('neck', 100)"
              :src="getBadgeImage('count100')"
              :alt="getBadgeAltText('neck_count100')"
            />
          </div>
        </div>
      </div>
      <div class="badge-item">
        <p>shoulder</p>
        <div class="badge-images">
          <div class="badge-image" v-if="checkBadge('shoulder', 5)">
            <img
              v-if="checkBadge('shoulder', 5)"
              :src="getBadgeImage('count5')"
              :alt="getBadgeAltText('shoulder_count5')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('shoulder', 10)">
            <img
              v-if="checkBadge('shoulder', 10)"
              :src="getBadgeImage('count10')"
              :alt="getBadgeAltText('shoulder_count10')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('shoulder', 20)">
            <img
              v-if="checkBadge('shoulder', 20)"
              :src="getBadgeImage('count20')"
              :alt="getBadgeAltText('shoulder_count20')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('shoulder', 50)">
            <img
              v-if="checkBadge('shoulder', 50)"
              :src="getBadgeImage('count50')"
              :alt="getBadgeAltText('shoulder_count50')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('shoulder', 100)">
            <img
              v-if="checkBadge('shoulder', 100)"
              :src="getBadgeImage('count100')"
              :alt="getBadgeAltText('shoulder_count100')"
            />
          </div>
        </div>
      </div>
      <div class="badge-item">
        <p>back</p>
        <div class="badge-images">
          <div class="badge-image" v-if="checkBadge('back', 5)">
            <img
              v-if="checkBadge('back', 5)"
              :src="getBadgeImage('count5')"
              :alt="getBadgeAltText('back_count5')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('back', 10)">
            <img
              v-if="checkBadge('back', 10)"
              :src="getBadgeImage('count10')"
              :alt="getBadgeAltText('back_count10')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('back', 20)">
            <img
              v-if="checkBadge('back', 20)"
              :src="getBadgeImage('count20')"
              :alt="getBadgeAltText('back_count20')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('back', 50)">
            <img
              v-if="checkBadge('back', 50)"
              :src="getBadgeImage('count50')"
              :alt="getBadgeAltText('back_count50')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('back', 100)">
            <img
              v-if="checkBadge('back', 100)"
              :src="getBadgeImage('count100')"
              :alt="getBadgeAltText('back_count100')"
            />
          </div>
        </div>
      </div>
      <div class="badge-item">
        <p>eye</p>
        <div class="badge-images">
          <div class="badge-image" v-if="checkBadge('eye', 5)">
            <img
              v-if="checkBadge('eye', 5)"
              :src="getBadgeImage('count5')"
              :alt="getBadgeAltText('eye_count5')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('eye', 10)">
            <img
              v-if="checkBadge('eye', 10)"
              :src="getBadgeImage('count10')"
              :alt="getBadgeAltText('eye_count10')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('eye', 20)">
            <img
              v-if="checkBadge('eye', 20)"
              :src="getBadgeImage('count20')"
              :alt="getBadgeAltText('eye_count20')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('eye', 50)">
            <img
              v-if="checkBadge('eye', 50)"
              :src="getBadgeImage('count50')"
              :alt="getBadgeAltText('eye_count50')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('eye', 100)">
            <img
              v-if="checkBadge('eye', 100)"
              :src="getBadgeImage('count100')"
              :alt="getBadgeAltText('eye_count100')"
            />
          </div>
        </div>
      </div>
      <div class="badge-item">
        <p>hand</p>
        <div class="badge-images">
          <div class="badge-image" v-if="checkBadge('hand', 5)">
            <img
              v-if="checkBadge('hand', 5)"
              :src="getBadgeImage('count5')"
              :alt="getBadgeAltText('hand_count5')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('hand', 10)">
            <img
              v-if="checkBadge('hand', 10)"
              :src="getBadgeImage('count10')"
              :alt="getBadgeAltText('hand_count10')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('hand', 20)">
            <img
              v-if="checkBadge('hand', 20)"
              :src="getBadgeImage('count20')"
              :alt="getBadgeAltText('hand_count20')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('hand', 50)">
            <img
              v-if="checkBadge('hand', 50)"
              :src="getBadgeImage('count50')"
              :alt="getBadgeAltText('hand_count50')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('hand', 100)">
            <img
              v-if="checkBadge('hand', 100)"
              :src="getBadgeImage('count100')"
              :alt="getBadgeAltText('hand_count100')"
            />
          </div>
        </div>
      </div>
      <div class="badge-item">
        <p>leg</p>
        <div class="badge-images">
          <div class="badge-image" v-if="checkBadge('leg', 5)">
            <img
              v-if="checkBadge('leg', 5)"
              :src="getBadgeImage('count5')"
              :alt="getBadgeAltText('leg_count5')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('leg', 10)">
            <img
              v-if="checkBadge('leg', 10)"
              :src="getBadgeImage('count10')"
              :alt="getBadgeAltText('leg_count10')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('leg', 20)">
            <img
              v-if="checkBadge('leg', 20)"
              :src="getBadgeImage('count20')"
              :alt="getBadgeAltText('leg_count20')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('leg', 50)">
            <img
              v-if="checkBadge('leg', 50)"
              :src="getBadgeImage('count50')"
              :alt="getBadgeAltText('leg_count50')"
            />
          </div>
          <div class="badge-image" v-if="checkBadge('leg', 100)">
            <img
              v-if="checkBadge('leg', 100)"
              :src="getBadgeImage('count100')"
              :alt="getBadgeAltText('leg_count100')"
            />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { mapState } from "vuex";
export default {
  props: ["loginUserInfo"],
  computed: {
    ...mapState({
      badges: (state) => state.MypageIndex.badges,
    }),
  },
  created() {
    this.$store.dispatch("MypageIndex/getBadge", this.loginUserInfo.userNo);
  },
  methods: {
    checkBadge(badgeKey, count) {
      return this.badges[`${badgeKey}_count${count}`];
    },
    getBadgeImage(countkey) {
      return require(`@/assets/badges/${countkey}.png`);
    },
    getBadgeAltText(badgeKey) {
      return badgeKey.replace(/_/g, " ").toUpperCase() + " Badge";
    },
  },
};
</script>

<style>
.title {
  font-size: 30px;
}
.badge-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: flex-start;
  gap: 20px;
  background-color: #f8f8f8;
  padding: 10px;
  border: 2px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

.badge-item {
  flex-basis: calc(33.33% - 40px);
  height: 200px;
  text-align: center;
  background-color: hsl(289, 64%, 91%);
}

.badge-item p {
  font-weight: bold;
  font-size: 20px;
  color: hwb(258 45% 6%);
}

.badge-item .badge-images {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  height: 140px;
  overflow: hidden;
}

.badge-item .badge-images .badge-image {
  width: 50px;
  height: 50px;
  margin: 5px;
}

.badge-item .badge-images img {
  max-width: 100%;
  max-height: 100%;
}
</style>
