<template>
  <div id="app">
    <DmsHeader/>
    <router-view></router-view>
    <DmsFooter/>
  </div>
</template>

<script>

import DmsHeader from "@/components/TheHeader";
import DmsFooter from "@/components/TheFooter";

export default {
  name: 'App',
  components: {DmsFooter, DmsHeader},
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

