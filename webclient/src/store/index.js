import Vue from 'vue'
import Vuex from 'vuex'
import firebase from 'firebase/app'
import 'firebase/auth'
import axios from 'axios'
// import router from '../router/index'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    loginDisplay: true,
    loggedIn: false,
    userProfile: { name: 'John', shop_name: 'test', email: 'test@gmail.com' }
  },
  mutations: {
    changeLoginDisplay (state) {
      state.loginDisplay = !state.loginDisplay
    },
    signOut (state) {
      state.loggedIn = false
    },
    logIn (state) {
      state.loggedIn = true
    },
    setUserProfile (state, val) {
      state.userProfile = val
      state.loggedIn = true
    }
  },
  actions: {
    checkUser ({ commit }) {
      if (firebase.auth().currentUser) commit('logIn')
      else commit('signOut')
    },
    changeLoginDisplay ({ commit }) {
      commit('changeLoginDisplay')
    },
    signOut ({ commit }) {
      commit('signOut')
    },

    async login ({ dispatch }, form) {
      firebase.auth().signOut() // PRODUCTION LINE
      await firebase.auth().signInWithEmailAndPassword(form.email, form.password)
        .then(_ => {
          var user = firebase.auth().currentUser
          dispatch('fetchUserProfile', user)
        }).catch(err => console.log('Error:' + err))
    },

    async fetchUserProfile ({ commit }, user) {
      // fetch user profile
      await axios.get(`http://localhost:4001/all_users_types/${user.uid}`).then(userType => {
        axios.get(`http://localhost:4001/${userType.data}/${user.uid}`).then(response => {
          commit('setUserProfile', response.data)
        }).catch(err => console.log(err))
      }).catch(err => console.log(err))
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
