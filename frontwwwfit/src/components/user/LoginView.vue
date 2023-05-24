<template>
  <div>
    <section class="vh-100" style="background-color: #eee">
      <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
          <div class="col-sm-12 col-sm-11">
            <div class="card text-black" style="border-radius: 25px">
              <div class="card-body p-md-1">
                <main
                  class="form-signin w-50 m-auto"
                  style="
                    display: flex;
                    justify-content: center !important;
                    align-items: center;
                    padding: 100px 0px;
                  "
                >
                  <form>
                    <h1 class="h3 mb-3 fw-normal">로그인 {{ loginUser }}</h1>
                    <label for="floatingInput">ID</label>
                    <div class="form-floating">
                      <input
                        type="text"
                        class="form-control"
                        id="floatingInput"
                        placeholder="ID"
                        v-model="userId"
                      />
                    </div>
                    <label for="floatingPassword">Password</label>
                    <div class="form-floating">
                      <input
                        type="password"
                        class="form-control"
                        id="floatingPassword"
                        placeholder="Password"
                        v-model="password"
                      />
                    </div>
                    <br />
                    <!-- <div class="checkbox mb-3">
          <label>
            <input type="checkbox" value="remember-me" /> Remember me
          </label>
        </div> -->
                    <button
                      class="w-100 btn btn-lg btn-primary"
                      @click.prevent="login"
                    >
                      로그인
                    </button>
                    <div class="kakao_img">
                      <img
                        src="../../assets/kakao_login.png"
                        @click="kakaoLogin()"
                        style="width: 100%; height: 55px"
                      />
                    </div>
                    <p class="mt-5 mb-3 text-body-secondary">©WWWfit</p>
                  </form>
                </main>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import { mapState } from "vuex";
import axios from "axios";
export default {
  name: "LoginView",
  data() {
    return {
      // user: {
      userId: "",
      password: "",
      // },
    };
  },
  computed: {
    ...mapState({
      loginUser: (state) => state.UserIndex.loginUser,
    }),
  },
  methods: {
    login() {
      let user = {
        userId: this.userId,
        password: this.password,
      };
      console.log("login attempt");
      this.$store.dispatch("UserIndex/loginUser", user);
    },
    kakaoLogin() {
      const param = {
        redirectUri: "http://localhost:8080/login",
      };
      window.Kakao.Auth.authorize(param);
    },
    getToken() {
      const API_URL = "http://localhost:9999/api-user/auth/kakao/callback";

      axios({
        url: API_URL,
        method: "GET",
        params: {
          code: this.$route.query.code,
        },
      }).then((res) => {
        let user = {
          userId: res.data.userId,
          password: res.data.password,
        };
        this.$store.dispatch("UserIndex/loginUser", user);
      });
    },
  },
  created() {
    if (this.$route.query.code) {
      console.log("카카오코드: " + this.$route.query.code); //인가 코드

      this.getToken();
    }
  },
};
</script>

<style></style>
