import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
// import UserView from "../views/UserView.vue";
import MypageView from "../views/MypageView.vue";
import LoginView from "../components/user/LoginView.vue";
import RegistView from "../components/user/RegistView.vue";
import InfoView from "../components/user/InfoView.vue";
// import PostListView from "../components/post/PostListView.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
    // children: [
    //   {
    //     path: "/poster",
    //     name: "main",
    //     component: PostListView,
    //   },
    // ],
  },
  {
    path: "/mypage",
    name: "mypage",
    component: MypageView,
  },
  // {
  // path: "/user",
  // name: "user",
  // component: UserView,
  // children: [
  {
    path: "/login",
    name: "login",
    component: LoginView,
  },
  {
    path: "/regist",
    name: "regist",
    component: RegistView,
  },
  {
    path: "/info",
    name: "userinfo",
    component: InfoView,
  },
  // ],
  // },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
