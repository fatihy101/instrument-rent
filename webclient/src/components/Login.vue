<template>
  <transition name="slide">
    <v-sheet v-if="this.$store.getters.getLoginDisplay && !this.$store.getters.getLoggedIn" rounded="lg" class="d-flex justify-center mt-2" dark color="primary lighten-1" elevation="15">
        <v-form lazy-validation @submit.prevent="signInEvent" class="mx-n5">
            <v-text-field label="E-postanız" v-model="email"></v-text-field>
            <div>
                <v-text-field label="Parolanız" type="password" v-model="password"></v-text-field>
                <small class="d-flex justify-end subtitle-2 font-weight-light"><a href="#" style="color:white;">Parolamı Unuttum</a></small>
            </div>
            <v-btn color="primary" type="submit" class="ml-5 mt-7 mb-4 d-flex justify-center">
                Giriş Yap <v-icon>mdi-account</v-icon>
            </v-btn>
            <v-divider></v-divider>
            <v-btn color="accent darken-2" class="ml-5 my-5" @click="$store.commit('changeLoginDisplay')">
                Kaydol <v-icon>mdi-account-plus</v-icon>
            </v-btn>
        </v-form>
    </v-sheet>
  </transition>
</template>

<script>
import firebase from 'firebase/app'
import 'firebase/auth'
export default {
  name: 'Login',
  data: () => ({
    show: null,
    email: null,
    password: null,
    errors: []
  }),
  methods: {
    async signInEvent () {
      await firebase.auth().signInWithEmailAndPassword(this.email, this.password)
        .catch(function (error) {
          var errorCode = error.code
          var errorMessage = error.message
          if (errorCode === 'auth/wrong-password') {
            alert('Wrong password.')
          } else {
            alert(errorMessage)
          }
          console.log(error)
        })
    }
  }
}
</script>

<style lang="scss" scoped>

</style>
