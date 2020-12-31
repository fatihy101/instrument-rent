import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import axios from 'axios'
import firebase from 'firebase/app'

Vue.prototype.$axios = axios
Vue.config.productionTip = false

// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: 'AIzaSyDdkRWNTnrhCNgIKnZGYe39A9Wv3oQcdvc',
  authDomain: 'enstrurent.firebaseapp.com',
  projectId: 'enstrurent',
  storageBucket: 'enstrurent.appspot.com',
  messagingSenderId: '430164056685',
  appId: '1:430164056685:web:f9161a162755a2cffebd64'
}
// Initialize Firebase
firebase.initializeApp(firebaseConfig)

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
