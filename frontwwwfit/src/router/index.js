import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import MypageView from "../views/MypageView.vue";
import LoginView from "../components/user/LoginView.vue";
import RegistView from "../components/user/RegistView.vue";
import InfoView from "../components/user/InfoView.vue";
import PostView from "../views/PostView.vue";
import PostDetailView from "./components/post/PostDetailView.vue";
import PostListView from "./components/post/PostListView.vue";
import BookmarkView from "../views/BookmarkView.vue";
import BookmarkFolderView from "./components/bookmark/BookmarkFolderView.vue";
import BookmarkListView from "./components/bookmark/BookmarkListView.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/mypage",
    name: "mypage",
    component: MypageView,
  },
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
  {
    path: "/bookemark",
    name: "bookemark",
    component: BookmarkView,
    children: [
      {
        path: "list",
        name: "list",
        component: BookmarkListView,
      },
      {
        path: "Folder",
        name: "Folder",
        component: BookmarkFolderView,
      },
    ],
  },
  {
    path: "/post",
    name: "post",
    component: PostView,
    children: [
      {
        path: "detail",
        name: "detail",
        component: PostDetailView,
      },
      {
        path: "list",
        name: "list",
        component: PostListView,
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
