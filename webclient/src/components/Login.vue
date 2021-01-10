<template>
  <transition name="slide">
    <v-sheet v-if="this.$store.getters.getLoginDisplay && !this.$store.getters.getLoggedIn"
    rounded="lg" class="d-flex justify-center mt-2"
    dark color="primary lighten-1" elevation="15">
        <v-form lazy-validation @submit.prevent="login()" class="mx-n5">
            <v-text-field label="E-postanız" v-model.trim="email"></v-text-field>
            <div>
                <v-text-field label="Parolanız" type="password" v-model.trim="password"></v-text-field>
                <small class="d-flex justify-end subtitle-2 font-weight-light"><a href="#" style="color:white;">Parolamı Unuttum</a></small>
            </div>
            <v-btn color="secondary darken-1" type="submit" class="ml-5 mt-7 mb-4 d-flex justify-center">
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
export default {
  name: 'Login',
  data: () => ({
    email: null,
    password: null,
    errors: []
  }),
  methods: {
    // Function for dispatching items to Vuex
    login () {
      this.$store.dispatch('login', {
        email: this.email,
        password: this.password
      })
    }
  }
}
</script>

<style lang="scss" scoped>

</style>
