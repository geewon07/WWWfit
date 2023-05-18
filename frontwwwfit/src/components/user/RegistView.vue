<template>
  <div>
    <section class="vh-100" style="background-color: #eee">
      <div class="container">
        <div class="row d-flex justify-content-center align-items-center h-100">
          <div class="col-sm-12 col-sm-11">
            <div class="card text-black" style="border-radius: 25px">
              <div class="card-body p-md-5">
                <div class="row justify-content-center">
                  <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                    <p class="h3 fw-bold mb-5 mx-1 mx-md-4 mt-4">회원가입</p>
                    <form class="mx-1 mx-md-4">
                      <label class="form-label" for="useridform">
                        아이디
                      </label>
                      <div class="d-flex flex-row align-items-center mb-4">
                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                        <div class="form-outline flex-fill mb-0">
                          <input
                            type="text"
                            id="useridform"
                            class="form-control"
                            v-model.trim="userId"
                          />
                        </div>
                      </div>

                      <label class="form-label" for="usernameform">
                        이름
                      </label>
                      <div class="d-flex flex-row align-items-center mb-4">
                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                        <div class="form-outline flex-fill mb-0">
                          <input
                            type="text"
                            id="usernameform"
                            class="form-control"
                            v-model.trim="name"
                          />
                        </div>
                      </div>

                      <label class="form-label" for="useremailform">
                        이메일
                      </label>
                      <div class="d-flex flex-row align-items-center mb-4">
                        <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                        <div class="form-outline flex-fill mb-0">
                          <input
                            type="email"
                            id="useremailform"
                            class="form-control"
                            v-model.trim="email"
                          />
                        </div>
                      </div>

                      <label class="form-label" for="userpwform">
                        비밀번호
                      </label>
                      <div class="d-flex flex-row align-items-center mb-4">
                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                        <div class="form-outline flex-fill mb-0">
                          <input
                            type="password"
                            id="userpwform"
                            class="form-control"
                            v-model.trim="password"
                          />
                        </div>
                      </div>

                      <label class="form-label" for="form3Example4cd">
                        비밀번호 확인
                      </label>
                      <div class="d-flex flex-row align-items-center mb-4">
                        <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                        <div class="form-outline flex-fill mb-0">
                          <input
                            type="password"
                            id="form3Example4cd"
                            class="form-control"
                            v-model="pwcheck"
                          />
                        </div>
                      </div>

                      <!-- <div class="form-check d-flex justify-content-left mb-5">
                        <input
                          class="form-check-input me-2"
                          type="checkbox"
                          value=""
                          id="form2Example3c"
                        />
                        <label class="form-check-label" for="form2Example3">
                          I agree all statements in
                          <a href="#!">Terms of service</a>
                        </label>
                      </div> -->

                      <div
                        class="d-flex justify-content-center mx-4 mb-3 mb-lg-4"
                      >
                        <button
                          v-show="pwsamecheck"
                          type="button"
                          @click="doRegist"
                          class="btn btn-primary btn-lg"
                        >
                          가입
                        </button>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
// import { mapActions } from "vuex";

export default {
  name: "RegistView",
  data() {
    return {
      name: "",
      userId: "",
      password: "",
      pwcheck: "",
      email: "",
    };
  },
  computed: {
    pwsamecheck() {
      if (this.password === this.pwcheck) {
        return true;
      } else {
        return false;
      }
    },
  },

  methods: {
    doRegist() {
      let user = {
        name: this.name,
        userId: this.userId,
        password: this.password,
        email: this.email,
      };
      this.$store.dispatch("registUser", user);
    },
  },
};
</script>

<style></style>
