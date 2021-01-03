import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    loginDisplay: true
  },
  mutations: {
    changeLoginDisplay (state, payload) {
      state.loginDisplay = !state.loginDisplay
    }
  },
  actions: {
    changeLoginDisplay ({ commit }) {
      commit('changeLoginDisplay')
    }
  },
  modules: {
  },
  getters: {
    getLoginDisplay: state => state.loginDisplay
  }
})
