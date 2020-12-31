import Vue from 'vue'
import VueRouter from 'vue-router'

// View Imports
import Home from '../views/Home.vue'
import About from '../views/About.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/hakkimizda',
    name: 'About',
    component: About
  }
]

const router = new VueRouter({
  routes,
  mode: 'history'
})

export default router
