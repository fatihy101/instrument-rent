<template>
   <transition name="slide">
      <v-sheet v-if="this.$store.getters.getLoggedIn"
      rounded="lg"
      class="d-flex justify-center mt-2"
      dark color="secondary"
      elevation="15">
        <div class="justify-center">
          <!-- Profile Photo -->
          <v-list color="primary" class="px-10">
            <v-list-item class="px-0">
              <v-list-item-avatar>
                <v-img v-if="profilePicture" src="profilePicture"></v-img>
                <v-img v-else><v-icon size="50">mdi-account-circle</v-icon> </v-img>
              </v-list-item-avatar>
            </v-list-item>
            <!-- ./Profile Photo -->
            <!-- Name Surname or Shopname -->
            <v-list-item link :class="currentEmail.length > 0 ? 'px-5' :  'px-10' ">
              <v-list-item-content>
                <v-list-item-title class="title">
                  {{ displayFullname }}
                </v-list-item-title>
                <v-list-item-subtitle> {{ currentEmail }} </v-list-item-subtitle>
              </v-list-item-content>

              <v-list-item-action>
                <v-icon>mdi-menu-down</v-icon>
              </v-list-item-action>
            </v-list-item>
            <!-- /Name Surname or Shopname -->
          </v-list>
          <v-divider></v-divider>
         <!-- User Menu -->
          <v-list nav dense color="secondary" rounded>
            <v-list-item-group
            v-model="selectedItem"
            color="primary" >
              <!-- Menu -->
              <router-link
                class="no-underline"
                v-for="(menu_item, index) in menu_items"
                :key="index"
                :to="menu_item.path" >
                <v-list-item>
                  <!-- Item's icon -->
                  <v-list-item-icon>
                  <v-icon v-text="menu_item.icon" light />
                  </v-list-item-icon>
                  <!-- /Item's icon -->
                  <v-list-item-content>
                    <v-list-item-title style="color: black;"
                    v-text="menu_item.text"/>
                  </v-list-item-content>
                </v-list-item>
              </router-link>
              <!--  /Menu -->
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
    menu_items: null,
    selectedItem: null,
    clientMenuItems: [
      { text: 'Profilimi Görüntüle', path: '', icon: 'mdi-account-circle-outline' }
    ],
    renterMenuItems: [
      { text: 'Mağaza Paneli', path: '', icon: 'mdi-view-dashboard' },
      { text: 'Profili Görüntüle', path: '', icon: 'mdi-account-circle' },
      { text: 'Ürün Ekle', path: '/enstruman-ekle', icon: 'mdi-plus-box' },
      { text: 'Ürünlerimi Görüntüle', path: '', icon: 'mdi-music-box-multiple' },
      { text: 'Gelen Siparişler', path: '', icon: 'mdi-file' },
      { text: 'Bekleyen Siparişler', path: '', icon: 'mdi-file-alert' }
    ]
  }),
  methods: {
    signOut () {
      const that = this
      firebase.auth().signOut().then(function () {
        that.$store.dispatch('signOut')
      }).catch(function (error) {
        console.log(`Error: ${error.message}`)
      })
    }
  },
  computed: {
    displayFullname () {
      return (`${this.$store.getters.getUserProfile.name} ${this.$store.getters.getUserProfile.surname}`)
    },
    currentEmail () {
      return this.$store.getters.getUserProfile.email
    },
    profilePicture () {
      return this.$store.getters.getUserProfile.profile_picture
    }
  },
  updated () {
    // Logic: If shop_name exists, it's a renter else client.
    if (this.$store.getters.getUserProfile.shop_name) this.menu_items = this.renterMenuItems
    else this.menu_items = this.clientMenuItems
  }

}
</script>

<style lang="scss" scoped>

</style>
