import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    loginDisplay: true,
    loggedIn: true
  },
  mutations: {
    changeLoginDisplay (state) {
      state.loginDisplay = !state.loginDisplay
    },
    loggingIn (state) {
      state.loggedIn = true
    },
    signOut (state) {
      state.loggedIn = false
    }
  },
  actions: {
    changeLoginDisplay ({ commit }) {
      commit('changeLoginDisplay')
    },
    loggingIn ({ commit }) {
      commit('loggingIn')
    },
    signOut ({ commit }) {
      commit('signOut')
    }
  },
  modules: {
  },
  getters: {
    getLoginDisplay: state => state.loginDisplay,
    getLoggedIn: state => state.loggedIn
  }
})
