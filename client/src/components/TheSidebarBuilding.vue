<template>
  <div>
    <ul class="nav flex-column text-justify">
      <li class="nav-item">
        <router-link
            class="nav-link"
            exact
            :to="{name:'buildings'}"
        >
          建物
        </router-link>
      </li>
      <li class="nav-item">
        <router-link
            class="nav-link"
            exact
            :to="{name: 'room'}"
        >
          部屋
        </router-link>
      </li>
    </ul>
  </div>
</template>

<script>

export default {
  name: "BuildingSideBar",
}
</script>