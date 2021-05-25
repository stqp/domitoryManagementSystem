<template>
  <div class="container row">
    <BuildingSideBar class="col-3"/>
    <transition name="fade">
      <router-view class="col-9"></router-view>
    </transition>
  </div>

</template>

<script>
import BuildingSideBar from "@/components/TheSidebarBuilding";

export default {
  name: 'BuildingManagement',
  components: {BuildingSideBar},
}
</script>