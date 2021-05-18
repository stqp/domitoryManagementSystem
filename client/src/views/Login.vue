<template>
  <div class="signin container page">
    <div class="row justify-content-center">
      <div class="col-sm-6">
        <h2>Sign in</h2>
        <form @submit.prevent="doSignIn(email, password)">
          <fieldset class="form-group">
            <input
                class="form-control form-control-lg"
                type="text"
                v-model="email"
                placeholder="Email"
            >
          </fieldset>
          <fieldset class="form-group">
            <input
                class="form-control form-control-lg"
                type="password"
                v-model="password"
                placeholder="Password"
            />
          </fieldset>
          <div class="float-right">
            <button class="btn btn-lg  btn-primary">
              Sign in
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import {mapState} from "vuex";
import {LOGIN} from "@/store/actions.type.js";

export default {
  name: "DmsLogin",
  data() {
    return {
      email: '',
      password: ''
    };
  },
  methods: {
    doSignIn(email, password) {
      this.$store
          .dispatch(LOGIN, {email, password})
          .then(() => this.$router.push({name: "home"}));
    },
  },
  computed: {
    ...mapState({
      errors: state => state.auth.errors
    })
  }
}
</script>

