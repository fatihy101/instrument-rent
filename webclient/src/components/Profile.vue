<template>
   <transition name="slide">
      <v-sheet v-if="this.$store.getters.getLoggedIn" rounded="lg" class="d-flex justify-center mt-2" dark color="secondary" elevation="15">
        <div class="justify-center">
          <!-- Profile Photo -->
          <v-list color="primary" class="px-6">
            <v-list-item class="px-0">
              <v-list-item-avatar>
                <v-img src="https://cdn.vuetifyjs.com/images/john.png"></v-img>
              </v-list-item-avatar>
            </v-list-item>
            <!-- ./Profile Photo -->
            <!-- Name Surname or Shopname -->
            <v-list-item link class="px-0">
              <v-list-item-content>
                <v-list-item-title class="title">
                  {{ displayName }}
                </v-list-item-title>
                <v-list-item-subtitle>john@domain.com</v-list-item-subtitle>
              </v-list-item-content>

              <v-list-item-action>
                <v-icon>mdi-menu-down</v-icon>
              </v-list-item-action>
            </v-list-item>
            <!-- /Name Surname or Shopname -->
          </v-list>
          <v-divider></v-divider>
         <!-- User Menu -->
          <v-list nav dense color="secondary">
            <v-list-item-group
            v-model="selectedItem"
            color="primary"
            >
              <div v-if="$store.getters.getUserProfile.shop_name">
                <!-- Renter menu -->
                <v-list-item v-for="(menu_item, index) in renterMenuItems" :key="index" >
                  <a> {{ menu_item.text }} </a>
                </v-list-item>
                <!-- /Renter menu -->
              </div>
              <div v-else>
                <!-- Client menu -->
                <v-list-item v-for="(menu_item, index) in clientMenuItems" :key="index">
                  <v-btn text> {{ menu_item.text }} </v-btn>
                </v-list-item>
                <!-- /Client menu -->
              </div>
            </v-list-item-group>
           <!-- Log Out Button -->
            <v-list-item>
                <v-btn  block @click="signOut()" color="error" class="mt-4 mb-2"><v-icon>mdi-logout</v-icon> Çıkış Yap </v-btn>
            </v-list-item>
            <!-- ./Log Out Button -->
          </v-list >
          <!-- ./User Menu -->

        </div>

      </v-sheet>
  </transition>
</template>

<script>
import firebase from 'firebase/app'
import 'firebase/auth'

export default {
  data: () => ({
    selectedItem: null,
    clientMenuItems: [
      { text: 'Profilimi Görüntüle', path: '' }
    ],
    renterMenuItems: [
      { text: 'Mağaza Paneli', path: '' },
      { text: 'Profili Görüntüle', path: '' },
      { text: 'Ürün Ekle', path: '' },
      { text: 'Ürünlerimi Görüntüle', path: '' },
      { text: 'Gelen Siparişler', path: '' },
      { text: 'Bekleyen Siparişler', path: '' }
    ]
  }),
  methods: {
    signOut () {
      firebase.auth().signOut().then(function () {
        this.$store.commit('signOut')
      }).catch(function (error) {
        console.log(error.message)
      })
    }
  },
  computed: {
    displayName () {
      return this.$store.getters.getUserProfile.display_name
    }
  }

}
</script>

<style>

</style>
