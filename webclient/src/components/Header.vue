<template v-slot:extension >
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
              :src="require('../assets/logo_white.png')"
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
              <router-link v-for="(item, index) in menuItems" :key="index" :to="item.path">
                <v-btn target="_blank" text class="mr-2" >
                  <span class="mr-1">{{item.title}}</span>
                  <v-icon>{{item.icon}}</v-icon>
                </v-btn>
              </router-link>

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
                top
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
</template>

<script>
export default {
  name: 'Header',
  data: () => ({
    menuItems: [
      { title: 'Ana Sayfa', path: '/', icon: 'mdi-home' },
      { title: 'Hakkımızda', path: '/hakkimizda', icon: 'mdi-information-outline' },
      { title: 'Nasıl çalışır?', path: '/nasil-calisir', icon: 'mdi-head-question-outline' }
    ]
  })

}
</script>

<style>

</style>
