import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            name: 'home',
            component: () => import("@/views/Home"),
        },
        {
            path: '/login',
            name: 'login',
            component: () => import('@/views/Login')
        },
        {
            path: '/logout',
            name: 'logout',
            component: () => import('@/views/Logout')
        },
        {
            path: '/building',
            name: 'building',
            component: () => import("@/components/BuildingManagement"),
            children: [
                {
                    path: 'buildings',
                    name: 'buildings',
                    component: () => import("@/components/Buildings")
                }
            ]
        },
    ]
})

