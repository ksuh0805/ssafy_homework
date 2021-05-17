import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/list',
    name: 'List',
    component: () => import(/* webpackChunkName: "about" */ '../views/List.vue')
  },
  {
    path: '/register',
    name: 'Reg',
    component: () => import(/* webpackChunkName: "about" */ '../views/Reg.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
