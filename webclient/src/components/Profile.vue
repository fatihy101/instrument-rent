<template>
   <transition name="slide">
      <v-sheet v-if="this.$store.getters.getLoggedIn" rounded="lg" class="d-flex justify-center mt-2" dark color="primary lighten-1" elevation="15">
        <div class="justify-center">
          <!-- Profile Photo -->
          <v-row class="ml-5 mt-2">
            <v-col>
              <v-avatar color="primary" size="48">
                <v-icon dark>
                mdi-account-circle
                </v-icon>
                <!-- TODO: Default avatar is inital letters of name and surname. -->
              </v-avatar>
            </v-col>
          </v-row>
          <!-- ./Profile Photo -->
          <!-- Name Surname or Shopname -->
          <v-row class="ml-1">
            <v-col>
              <h2 class="title">John Doe</h2>
            </v-col>
          </v-row>
         <!-- /Name Surname or Shopname -->

         <!-- User Menu -->
          <v-row>
            <v-col>
              <v-btn text>Adres Güncelle</v-btn>
            </v-col>
          </v-row>
          <!-- ./User Menu -->
          <!-- Log Out Button -->
          <v-row class="ml-n5 mb-1">
            <v-col>
              <v-btn @click="signOut()" color="error darken-1" class="ml-5 my-5"><v-icon>mdi-logout</v-icon> Çıkış Yap </v-btn>
            </v-col>
          </v-row>
          <!-- ./Log Out Button -->

        </div>

      </v-sheet>
  </transition>
</template>

<script>
import firebase from 'firebase/app'
import 'firebase/auth'

export default {
  methods: {
    signOut () {
      firebase.auth().signOut().then(function () {
        this.$store.commit('signOut')
      }).catch(function (error) {
        console.log(error.message)
      })
    }
  }

}
</script>

<style>

</style>
