<template>
  <div class="container page">
    Sign out...
  </div>
</template>

<script>
import {LOGOUT} from "@/store/actions.type.js";

export default {
  name: "DmsLogout",
  mounted() {
    console.log(this)
    this.$store
        .dispatch(LOGOUT)
        .then(() => this.$router.push({name: "home"}));
    console.log("hello")
  },
}
</script>

