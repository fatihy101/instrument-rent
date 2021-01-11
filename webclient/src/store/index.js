import Vue from 'vue'
import Vuex from 'vuex'
import firebase from 'firebase/app'
import 'firebase/auth'
import axios from 'axios'
import router from '../router/index'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    loginDisplay: true,
    loggedIn: true,
    userProfile: { display_name: 'John Doey', shop_name: 'test' }
  },
  mutations: {
    changeLoginDisplay (state) {
      state.loginDisplay = !state.loginDisplay
    },
    signOut (state) {
      state.loggedIn = false
    },
    setUserProfile (state, val) {
      state.userProfile = val
      state.loggedIn = true
    }
  },
  actions: {
    changeLoginDisplay ({ commit }) {
      commit('changeLoginDisplay')
    },
    signOut ({ commit }) {
      commit('signOut')
    },

    async login ({ dispatch }, form) {
      const user = await firebase.auth().signInWithEmailAndPassword(form.email, form.password)
      dispatch('fetchUserProfile', user)
    },

    async fetchUserProfile ({ commit }, user) {
      // fetch user profile
      await axios.get(`http://localhost:4001/clients/${user.uid}`).then(response => {
        console.log(`User profile: ${response} and data: ${response.data}`)
        commit('setUserProfile', response.data())
        router.push('/')
      }).catch(err => console.log(err))
      // set user profile in state
    }
  },
  modules: {
  },
  getters: {
    getLoginDisplay: state => state.loginDisplay,
    getLoggedIn: state => state.loggedIn,
    getUserProfile: state => state.userProfile
  }
})
