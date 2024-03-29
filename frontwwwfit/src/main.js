import Vue from "vue";
import "./plugins/bootstrap-vue";
import { BootstrapVue, BootstrapVueIcons } from "bootstrap-vue";
Vue.use(BootstrapVue);
Vue.use(BootstrapVueIcons);

import App from "./App.vue";
import router from "./router";
import store from "./store";
// Import the functions you need from the SDKs you need
import firebase from "firebase/app";
import "firebase/messaging";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyAf1RTS3Mb101hGxSd70lfpH4vPkDSpK3k",
  authDomain: "fit-66c29.firebaseapp.com",
  projectId: "fit-66c29",
  storageBucket: "fit-66c29.appspot.com",
  messagingSenderId: "1000689444688",
  appId: "1:1000689444688:web:c2175b4ffda57d727bae55",
  measurementId: "G-80QZNLXENE",
};

firebase.initializeApp(firebaseConfig);

const messaging = firebase.messaging();

messaging.usePublicVapidKey(
  "BDq8u24IERkcKWq9cZMDOHvGBENeZtOC98jtLsnYCcfT-Kf84CA_2_XXVxMt28Ud0kZSHFqVmh0T0LmmNozknRg"
);

// 알림 수신을 위한 사용자 권한 요청
Notification.requestPermission().then((permission) => {
  // console.log("permission ", permission);
  if (permission !== "granted") {
    alert("알림을 허용해주세요");
  }
});

// TODO: Send token to server for send notification
messaging.getToken().then(console.log);

// Handle received push notification at foreground
messaging.onMessage((payload) => {
  // console.log(payload);
  alert(payload.data.content);
});

Vue.config.productionTip = false;

window.Kakao.init("35c7d27f96655d764a1d5d15a3981b9f");

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
