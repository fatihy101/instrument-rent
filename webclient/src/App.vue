<template>
  <v-app>
    <!-- Header -->
    <!-- TODO: remove hide-on-scroll. Make custom function to hide app-bar -->
    <v-app-bar app
      color="primary"
      dark
      elevate-on-scroll
      hide-on-scroll
      height="220px">
      <v-container>
        <!--LOGO-->
        <v-row no-gutters>
          <v-col class="d-flex justify-center align-end">
            <v-img
              :src="require('./assets/logo_white.png')"
              class="mb-3 mt-4"
              contain
              max-height="200px"
              max-width="378px"
            />
          </v-col>
        </v-row>
        <!-- /LOGO -->
      </v-container>
      <!-- Toolbar -->
      <template v-slot:extension >
        <v-toolbar color="primary"
          outlined
          elevation="0" dense>
          <!-- Navbar -->
          <v-row no-gutters class="mb-2">
            <v-col class="d-flex justify-center">

              <v-btn target="_blank" text class="mr-2" v-for="(item, index) in menuItems" :key="index">
                <span class="mr-1">{{item.title}}</span>
                <v-icon>{{item.icon}}</v-icon>
              </v-btn>

            </v-col>
          </v-row>
          <!-- /Navbar -->
          <!-- Fab button -->
          <v-fab-transition>
              <v-btn
                id="search_bar"
                color="accent"
                fab
                absolute
                bottom
                right
              >
                <v-icon>mdi-magnify</v-icon>
              </v-btn>
          </v-fab-transition>
          <!-- /Fab button -->
        </v-toolbar>
      </template>
      <!-- /Toolbar -->
    </v-app-bar>
    <!-- /Header -->

    <v-main id="main_view">
      <v-container fluid>
        <v-sheet
          min-height="70vh"
          rounded="xl"
          class="mt-1" >
          <router-view></router-view>
        </v-sheet>
      </v-container>
    </v-main>

  <!-- Footer -->
   <v-footer
      dark
      padless >
      <v-card
      color="primary"
        flat
        tile
        class="text-center flex"
      >

      <v-card-text id="footer-text" class="white--text">
        {{ footer_text }}
      </v-card-text>

      <v-card-text>
        <v-btn
          v-for="icon in icons"
          :key="icon"
          class="mx-4 white--text"
          icon
        >
          <v-icon size="24px">
            {{ icon }}
          </v-icon>
        </v-btn>
      </v-card-text>

      <v-divider></v-divider>

      <v-card-text class="white--text">
        <p class="mute-text-footer">Copyright © {{ new Date().getFullYear() }} Enstrurent - All Rights Reserved.</p>
      </v-card-text>
    </v-card>
  </v-footer>
  <!-- /footer -->
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    footer_text: 'Eğer enstrümanlarınızı kiralatmak isteyen bir firmaysanız bize ulaşın!',
    menuItems: [
      { title: 'Ana Sayfa', path: '/home', icon: 'mdi-home' },
      { title: 'Hakkımızda', path: '/signup', icon: 'mdi-information-outline' },
      { title: 'Nasıl çalışır?', path: '/signin', icon: 'mdi-head-question-outline' }
    ],
    icons: [
      'mdi-facebook',
      'mdi-twitter',
      'mdi-linkedin',
      'mdi-instagram'
    ]
  })
}
</script>
<style lang="scss">
//To activate the purple background, uncomment. Remember <a> tags also purple.
#main_view {
  background-color:#450d82;
  color: #fff;
  }
  .mute-text-footer{
    color: #cfccd8;
    display: inline;
    font-size: 14px;
  }
  #footer-text{
    font-family: sans-serif;
    font-size: 18px;
  }

</style>
