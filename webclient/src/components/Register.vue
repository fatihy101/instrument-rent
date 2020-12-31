<template>
  <transition name="slide">
    <span v-if="show">
      <v-sheet rounded="lg" class="d-flex justify-center mt-2">
            <v-form lazy-validation @submit.prevent="register" class="mx-n5">
                <v-text-field label="E-posta" v-model="email"></v-text-field>
                <v-text-field label="Ad" type="text" v-model="name"></v-text-field>
                <v-text-field label="Soyad" type="text" v-model="surname"></v-text-field>
                <v-text-field label="Telefon No" type="text" v-model="phone_number"></v-text-field>
                <v-text-field label="Parola" type="password" v-model="password"></v-text-field>
                <v-text-field label="Parola tekrarı" type="password" v-model="password_re"></v-text-field>
                <!--TODO: Password strength check-->
                <v-btn color="success" type="submit" class="ml-5 my-5">
                    Kaydol <v-icon>mdi-account-check</v-icon>
                </v-btn>
                <v-btn color="accent" @click="show = !show" class="ml-5 my-5 d-flex">
                    Test <v-icon>mdi-account-check</v-icon>
                </v-btn>
            </v-form>
        </v-sheet>
    </span>
  </transition>
</template>

<script>
import firebase from 'firebase/app'
import 'firebase/auth'
import axios from 'axios'

export default {
  name: 'Register',
  data: () => ({
    show: true,
    email: '',
    name: '',
    surname: '',
    phone_number: '',
    password: '',
    password_re: ''
  }),
  methods: {
    async register () {
      await firebase.auth().createUserWithEmailAndPassword(this.email, this.password)
        .then(_ => console.log('first succession.')).catch(error => console.log(error))
      const user = firebase.auth().currentUser // Todo: Add an exception for if the email exists.
      const data = {
        id: user.uid,
        email: this.email,
        name: this.name,
        surname: this.surname,
        phone_number: this.phone_number
      }
      await axios.post('http://localhost:4001/clients/save', data, { timeout: 1000 })
        .then((response) => {
          alert('Kaydınız başarıyla tamamlandı.')
          console.log(response)
        }).catch(error => {
          console.log(error)
          user.delete().then(function () {
            alert('Hesabınız sunucuda oluşan bir hatadan dolayı oluşturulamadı. Daha sonra tekrar deneyin.')
          }).catch(error => { // It's very hard to occur but somehow it occurs, proabably something is wrong with firebase
            console.log(error)
            alert('Beklenmeyen bir hata oluştu. Hata Kodu: 1')
          })
        })
    }
  }

}
</script>

<style>
/* Enter and leave animations can use different */
/* durations and timing functions.              */
.slide-enter-active {
  transition: all .3s ease;
}
.slide-leave-active {
  transition: all .5s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}
.slide-enter, .slide-leave-to
/* .slide-fade-leave-active below version 2.1.8 */ {
  transform: translateX(10px);
  opacity: 0;
}
</style>
