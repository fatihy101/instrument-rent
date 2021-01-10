<template>
  <v-container class="mb-10">
    <!-- Toolbar -->
    <v-row>
      <v-col>
        <homeToolbar />
      </v-col>
    </v-row>
    <!-- /Toolbar -->
    <!-- Instrument cards -->
    <v-row >
      <v-col lg="3" md="4" sm="6">
        <instrumentCard />
      </v-col>
      <v-col lg="3" md="4" sm="6">
        <instrumentCard />
      </v-col>
      <v-col lg="3" md="4" sm="6">
        <instrumentCard />
      </v-col>
     <v-col lg="3" md="4" sm="6">
        <instrumentCard />
      </v-col>
      <v-col lg="3" md="4" sm="6">
        <instrumentCard />
      </v-col>
    </v-row>
    <!-- /Instrument cards -->
  </v-container>
</template>

<script>
// @ is an alias to /src
import instrumentCard from '@/components/instrumentCard.vue'
import homeToolbar from '@/components/homeToolbar.vue'

export default {
  name: 'Home',
  components: {
    instrumentCard,
    homeToolbar
  }
}
</script>
