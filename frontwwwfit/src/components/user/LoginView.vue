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
                    <h1 class="h3 mb-3 fw-normal">로그인</h1>
                    <label for="floatingInput">ID</label>
                    <div class="form-floating">
                      <input
                        type="text"
                        class="form-control"
                        id="floatingInput"
                        placeholder="ID"
                        v-model="user.id"
                      />
                    </div>
                    <label for="floatingPassword">Password</label>
                    <div class="form-floating">
                      <input
                        type="password"
                        class="form-control"
                        id="floatingPassword"
                        placeholder="Password"
                        v-model="user.password"
                      />
                    </div>
                    <br />
                    <!-- <div class="checkbox mb-3">
          <label>
            <input type="checkbox" value="remember-me" /> Remember me
          </label>
        </div> -->
                    <button class="w-100 btn btn-lg btn-primary" type="submit">
                      로그인
                    </button>
                    <p class="mt-5 mb-3 text-body-secondary">©WWWfit</p>
                  </form>
                </main>
              </div>
            </div>
          </div>
        </div>
      </div>
      >
    </section>
  </div>
</template>

<script>
export default {
  name: "LoginView",
  data() {
    return {
      user: {
        id: " ",
        password: "",
      },
    };
  },
};
</script>

<style></style>
