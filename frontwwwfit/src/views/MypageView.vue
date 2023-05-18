<template>
  <div>
    <div b-container fluid="md">
      <calendar-view></calendar-view>
    </div>
  </div>
</template>

<script>
import CalendarView from "@/components/mypage/CalendarView.vue";
// import { mapState } from "vuex";
export default {
  components: {
    CalendarView,
  },
};
</script>

<style></style>
