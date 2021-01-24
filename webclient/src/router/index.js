import Vue from 'vue'
import VueRouter from 'vue-router'

// View Imports
import Home from '../views/Home.vue'
import About from '../views/About.vue'
import AddInstrument from '../views/AddInstrument.vue'

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
  },
  {
    path: '/enstruman-ekle',
    name: 'AddInstrument',
    component: AddInstrument,
    meta: { requiresRenter: true }
  }
]

const router = new VueRouter({
  routes,
  mode: 'history'
})

router.beforeEach((to, from, next) => {
  if (to.meta.requiresRenter) {
    next()
    // requires Renter access.
    // alert('Satıcıya özel sayfa')
    // router.push('/')
  } else next()
})

export default router
