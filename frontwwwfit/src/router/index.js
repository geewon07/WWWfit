import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import MypageView from "../views/MypageView.vue";
import LoginView from "../components/user/LoginView.vue";
import RegistView from "../components/user/RegistView.vue";
import InfoView from "../components/user/InfoView.vue";
import PostView from "../views/PostView.vue";
import PostDetailView from "../components/post/PostDetailView.vue";
import PostListView from "../components/post/PostListView.vue";
import BookmarkView from "../views/BookmarkView.vue";
import BookmarkFolderView from "../components/bookmark/BookmarkFolderView.vue";
import BookmarkListView from "../components/bookmark/BookmarkListView.vue";
import SearchResult from "../components/home/SearchResult.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
    // children: [
    //   {
    //     path: "/searchresult",
    //     name: "sresult",
    //     component: SearchResult,
    //   },
    // ],
  },

  {
    path: "/searchresult",
    name: "sresult",
    component: SearchResult,
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
    path: "/bookmark",
    name: "bookmark",
    component: BookmarkView,
    children: [
      {
        path: "list",
        name: "blist",
        component: BookmarkListView,
      },
      {
        path: "folder",
        name: "folder",
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
        path: "list",
        name: "plist",
        component: PostListView,
      },
    ],
  },
  {
    path: "/detail/:posterSeq",
    name: "detail",
    component: PostDetailView,
    props: true,
    // children:[
    //   path:""
    // ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
