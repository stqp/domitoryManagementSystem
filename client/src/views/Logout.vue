<template>
  <div class="container page">
    Sign out...
  </div>
</template>

<script>
import {mapState} from "vuex";
import {LOGIN} from "@/store/actions.type.js";

export default {
  name: "DmsLogout",
  data() {
    return {};
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

