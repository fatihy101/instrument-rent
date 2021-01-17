<template>
  <v-app>
    <!-- TODO: remove hide-on-scroll. Make custom function to hide app-bar -->
    <Header @sidebarStatus="show_sidebar = $event"/>
    <v-main id="main_view">
      <v-container fluid>
      <v-row>
        <!-- Sidebar -->
        <v-col v-if="show_sidebar" lg="2" md="3" sm="4" xs="12">
          <Login/>
          <Register/>
          <Profile/>
        </v-col>
        <!-- /Sidebar -->
        <!-- main sheet, view -->
        <v-col :lg="show_sidebar ? 10 : 12" :md="show_sidebar ? 9 : 12"
        :sm="show_sidebar ? 8 : 12" :xs="show_sidebar ? 10 :12">
          <v-sheet dark
            min-height="45vh"
            rounded="lg"
            class="mt-2 mx-2 d-flex justify-content"
            color="primary lighten-1"
            elevation="10" >
            <router-view></router-view>
          </v-sheet>
        </v-col>
        <!-- /main sheet, view -->
      </v-row>
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
import Profile from './components/Profile.vue'

export default {
  name: 'App',

  data: () => ({
    show_sidebar: true
  }),
  components: {
    Login,
    Header,
    Footer,
    Register,
    Profile
  },
  mounted () {
    // Check the Firebase.CurrentUser
    this.$store.dispatch('checkUser')
  }
}
</script>

<style lang="scss">
// To activate the purple background, uncomment. Remember <a> tags also purple.
#main_view {
  background-color:#C0B5AF;
  color: #fff;
  background: linear-gradient(180deg, #3B3740 60%, #D9B54A 100%);
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
