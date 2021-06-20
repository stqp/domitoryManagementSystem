<template>
  <nav class="navbar navbar-light">
    <div class="container">
      <router-link class="navbar-brand" :to="{ name: 'home' }">
        DMS
      </router-link>
      <ul v-if="!isAuthenticated" class="nav pull-xs-right">
        <li class="nav-item">
          <router-link
              class="nav-link"
              active-class="active"
              exact
              :to="{ name: 'login' }"
          >
            <i class="ion-compose"></i>Sign in
          </router-link>
        </li>
      </ul>

      <ul v-if="isAuthenticated" class="nav pull-xs-right">
        <li class="nav-item">
          <router-link
              class="nav-link"
              active-class="active"
              exact
              :to="{ name: 'home' }"
          >
            Home
          </router-link>
        </li>
        <li class="nav-item">
          <router-link
              class="nav-link"
              active-class="active"
              exact
              :to="{ name: 'buildings' }"
          >
            建物管理
          </router-link>
        </li>
        <li class="nav-item">
          <!--          <router-link-->
          <!--              class="nav-link"-->
          <!--              active-class="active"-->
          <!--              exact-->
          <!--              :to="{ name: 'settings' }"-->
          <!--          >-->
          <!--            <i class="ion-gear-a"></i>&nbsp;Settings-->
          <!--          </router-link>-->
        </li>
        <li class="nav-item" v-if="currentUser.username">
          <router-link
              class="nav-link"
              active-class="active"
              exact
              :to="{
              name: 'profile',
              params: { username: currentUser.username }
            }"
          >
            {{ currentUser.username }}
          </router-link>
        </li>
        <li class="nav-item">
          <router-link
              class="nav-link"
              active-class="active"
              exact
              :to="{ name: 'logout' }"
          >
            Sign out
          </router-link>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
import {mapGetters} from "vuex";

export default {
  name: "DmsHeader",
  data() {
    return {}
  },
  computed: {
    ...mapGetters(["currentUser", "isAuthenticated"])
  }
}
</script>
