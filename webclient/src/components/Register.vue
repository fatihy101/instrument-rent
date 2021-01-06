<template>
  <transition name="slide">
    <v-sheet v-if="!$store.getters.getLoginDisplay && !this.$store.getters.getLoggedIn" rounded="lg" class="d-flex justify-center mt-2" dark color="primary lighten-1" elevation="15">
      <v-container>
        <v-row dense>
          <v-col>
            <v-btn class="mb-3" icon color="primary" @click="$store.commit('changeLoginDisplay')">
              <v-icon color="accent"> mdi-arrow-left-thick </v-icon>
            </v-btn>
            <v-divider></v-divider>
          </v-col>
        </v-row>
        <v-row>
          <v-col class="d-flex justify-center">
            <v-form lazy-validation @submit.prevent="register" class="mx-n5">
              <p v-if="errors.length"  style="color:pink; word-wrap:break-word;">
                <ul style="list-style-type:none;">
                  <li v-for="(error, index) in errors" :key="index">{{ error }}</li>
                </ul>
              </p>
                <!--TODO: Email format check -->
                <v-text-field label="E-posta" v-model.trim="email"></v-text-field>
                <v-text-field label="Ad" type="text" v-model.trim="name"></v-text-field>
                <v-text-field label="Soyad" type="text" v-model.trim="surname"></v-text-field>
                <birthdayPicker @birthdayDateChange="date = $event" />
                <v-text-field label="Telefon No" placeholder="+90" type="text" v-model.trim="phone_number"></v-text-field>
                <v-text-field label="Parola" type="password" v-model.trim="password"></v-text-field>
                <v-text-field label="Parola tekrarı" type="password" v-model.trim="password_re"></v-text-field>
                <!--TODO: Password strength check-->
                <v-btn color="success darken-2" :loading="loading" type="submit" class="ml-5 my-5">
                    Kaydol <v-icon>mdi-account-check</v-icon>
                </v-btn>
            </v-form>
          </v-col>
        </v-row>
      </v-container>
    </v-sheet>
  </transition>
</template>

<script>
import firebase from 'firebase/app'
import 'firebase/auth'
import axios from 'axios'
import birthdayPicker from './birthdayPicker.vue'

export default {
  name: 'Register',
  data: () => ({
    errors: [],
    loading: false,
    show: null,
    date: null,
    email: null,
    name: null,
    surname: null,
    phone_number: null,
    password: null,
    password_re: null
  }),
  methods: {
    async register () {
      this.loading = true
      if (this.checkForm()) {
        const formValues = [this.name, this.surname, this.email, this.password, this.password_re, this.phone_number]
        // Firebase
        await firebase.auth().createUserWithEmailAndPassword(this.email, this.password)
          .then(_ => console.log('first succession.')).catch(error => console.log(error))
        const user = firebase.auth().currentUser // Todo: Add an exception for if the email exists.
        const data = {
          id: user.uid,
          email: this.email,
          birthday_date: this.date,
          name: this.name,
          surname: this.surname,
          phone_number: this.phone_number
        }
        // Server
        await axios.post('http://localhost:4001/clients/save', data, { timeout: 1000 })
          .then((response) => {
            alert('Kaydınız başarıyla tamamlandı.')
            // To stop loading animation.
            this.loading = false
            // Set all the form values as null.
            for (this.value in formValues) this.value = null
          }).catch(error => {
            console.log(`Server err: ${error}`)
            user.delete().then(function () {
              this.errors.push('Hesabınız sunucuda oluşan bir hatadan dolayı oluşturulamadı. Daha sonra tekrar deneyin.')
              this.loading = false
            }).catch(error => { // It's very hard to occur but somehow it occurs, proabably something is wrong with firebase
              console.log(`Code 1: ${error}`)
              this.errors.push('Beklenmeyen bir hata oluştu. Kod: 1')
              this.loading = false
            })
          })
      }
      this.loading = false
    },
    passwordCheck () {
      if (this.password === null || this.password_re === null) {
        this.errors.push('Parola alanlarını doldurunuz.')
        return false
      } else {
        if (this.password === this.password_re) {
          return true
        } else {
          this.errors.push('Parola, tekrarı ile eşleşmiyor.')
          return false
        }
      }
    },
    checkForm () {
      this.errors = []
      if (this.passwordCheck()) {
        if (this.name && this.surname && this.email && this.password && this.password_re && this.phone_number) {
          return true
        }
        if (!this.name) {
          this.errors.push('Adınızı giriniz.')
        }
        if (!this.surname) {
          this.errors.push('Soyadınızı giriniz.')
        }
        if (!this.email) {
          this.errors.push('E-postanızı giriniz.')
        }
        if (!this.phone_number) {
          this.errors.push('Telefon numaranızı giriniz.')
        }
        if (!this.password) {
          this.errors.push('Parolanızı giriniz.')
        }
      }
    }
  },
  components: {
    birthdayPicker
  }

}
</script>
