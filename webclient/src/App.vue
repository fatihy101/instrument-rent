<template>
  <v-app>
    <!-- TODO: remove hide-on-scroll. Make custom function to hide app-bar -->
    <Header/>
    <v-main id="main_view">
      <v-container fluid>
      <v-row>
        <!-- Sidebar -->
        <v-col cols="2">
          <Login/>
          <Register/>
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

</style>
