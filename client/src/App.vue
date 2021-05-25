<template>
  <div id="app" class="container">
    <DmsHeader class="border-bottom"/>
    <transition name="fade">
      <router-view/>
    </transition>
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
.fade-enter-active {
  transition-duration: 0.5s;
  transition-property: opacity;
  transition-timing-function: ease;
}

.fade-leave-active {
  transition-duration: 0s;
  transition-property: opacity;
  transition-timing-function: ease;
}

.fade-enter,
.fade-leave-active {
  opacity: 0
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;
}
</style>

