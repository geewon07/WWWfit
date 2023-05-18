import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
// import UserView from "../views/UserView.vue";
import MypageView from "../views/MypageView.vue";
import LoginView from "../components/user/LoginView.vue";
import RegistView from "../components/user/RegistView.vue";
import InfoView from "../components/user/InfoView.vue";
<<<<<<< HEAD
// import PostListView from "../components/post/PostListView.vue";
=======
import PostView from "./components/user/PostView.vue";
import PostDetailView from "./components/user/PostDetailView.vue";
import PostListView from "./components/user/PostListView.vue";
import BookmarkView from "./components/user/BookmarkView.vue";
import BookmarkFolderView from "./components/user/BookmarkFolderView.vue";
import BookmarkListView from "./components/user/BookmarkListView.vue";
>>>>>>> c0a4750344383ef577a2972c8aba42b2733fdcbe

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
<<<<<<< HEAD
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
=======
    path: "/bookemark",
    name: "bookemark",
    component: bookemarkView,
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
>>>>>>> c0a4750344383ef577a2972c8aba42b2733fdcbe
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
