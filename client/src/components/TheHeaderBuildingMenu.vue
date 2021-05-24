<template>
  <div>
    <BuildingSideBar/>
    <router-view></router-view>
  </div>

</template>

<script>
import BuildingSideBar from "@/components/TheSidebarBuilding";

export default {
  name: 'Building',
  components: {BuildingSideBar},
}
</script>