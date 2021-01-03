<template>
  <v-app>
    <!-- TODO: remove hide-on-scroll. Make custom function to hide app-bar -->
    <Header/>
    <v-main id="main_view">
      <v-container fluid>
      <v-row>
        <!-- Sidebar -->
        <v-col cols="2">
          <Login @visibilityEvent="show_login = $event" :visibility="show_login"/>
          <Register :visibility="!show_login"/>
        </v-col>
        <!-- /Sidebar -->
        <!-- main sheet, view -->
        <v-col>
          <v-sheet
            min-height="70vh"
            rounded="lg"
            class="mt-2 mx-5 d-flex justify-center" >
            <router-view></router-view>
          </v-sheet>
        </v-col>
      </v-row>
        <!-- /main sheet, view -->
      </v-container>
    </v-main>
  <Footer/>
  </v-app>
</template>

<script>
import Footer from './components/Footer.vue'
import Header from './components/Header.vue'
import Login from './components/Login.vue'
import Register from './components/Register.vue'

export default {
  name: 'App',

  data: () => ({
    show_login: true
  }),
  components: {
    Login,
    Header,
    Footer,
    Register
  }
}
</script>

<style lang="scss">
//To activate the purple background, uncomment. Remember <a> tags also purple.
#main_view {
  background-color:#450d82;
  color: #fff;
  }

  /* Enter and leave animations can use different */
/* durations and timing functions.              */
.slide-enter-active {
  transition: all .4s ease;
}
.slide-leave-active {
  transition: all .2s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}
.slide-enter, .slide-leave-to
/* .slide-fade-leave-active below version 2.1.8 */ {
  transform: translateX(10px);
  opacity: 0;
}

</style>
