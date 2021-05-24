<template>
  <nav class="d-none d-md-block bg-light sidebar">
    <div>
      <ul class="nav flex-column">
        <li class="nav-item">
          <router-link
              class="nav-link"
              exact
              :to="contentbuilding"
          >
            建物
          </router-link>
        </li>
        <li class="nav-item">
          <router-link
              class="nav-link"
              exact
              :to="contentbuilding"
          >
            建物
          </router-link>
          部屋
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>

export default {
  name: "BuildingSideBar",
}
</script>