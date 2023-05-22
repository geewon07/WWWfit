<template>
  <div class="mylevel-container">
    <p class="title">알림</p>
    <div class="badge-container"></div>
  </div>
</template>

<script>
export default {
  props: ["loginUserInfo"],
};
</script>

<style scoped>
.badge-container {
  background-color: #f8f8f8;
  border: 2px solid #ccc;
  border-radius: 4px;
  padding: 20px;
}
</style>
