<template>
  <v-app>
    <!-- Header -->
    <v-app-bar app
      color="primary"
      dark
      elevate-on-scroll
      hide-on-scroll
      height="248px">
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
    <template v-slot:extension >
      <v-toolbar color="primary"
      outlined
      elevation="0" dense>
         <!-- Navbar -->
        <v-row no-gutters class="mb-2">
          <v-col class="d-flex justify-center">
            <v-btn target="_blank" text class="mr-2">
              <span class="mr-1">Ana Sayfa</span>
              <v-icon>mdi-home</v-icon>
            </v-btn>
             <v-btn target="_blank" text class="mr-2">
              <span class="mr-1">Nasıl Çalışır</span>
              <v-icon>mdi-head-question-outline</v-icon>
            </v-btn>
            <v-btn target="_blank" text class="mr-2">
              <span class="mr-1">Hakkımızda</span>
              <v-icon>mdi-information-outline</v-icon>
            </v-btn>
          </v-col>
        </v-row>
      <!-- /Navbar -->
      <!-- Fab button -->
        <v-fab-transition>
          <v-btn
            v-show="!hidden"
            color="warning"
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

    </v-app-bar>
    <!-- /Header -->

    <v-main id="main_view">
      <v-container fluid>
        <router-view></router-view>

        <!-- For test purposes -->
      <div v-for="n in 20" :key="n">
        <br>
      </div>
      </v-container>
    </v-main>

  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    menuItems: [
      { title: 'Ana Sayfa', path: '/home', icon: 'home' },
      { title: 'Hakkımızda', path: '/signup', icon: 'mdi-information-outline' },
      { title: 'Nasıl çalışır?', path: '/signin', icon: 'mdi-head-question-outline' }
    ]
  })
}
</script>
<style lang="scss" scoped>
/* //To activate the purple background, uncomment. Remember <a> tags also purple.
#main_view {
  background-color:#450d82;
  color: #fff;
  }
   */
</style>
