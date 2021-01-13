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
      <v-col v-for="(instrument, index) in instruments" :key="index" lg="3" md="4" sm="6">
        <instrumentCard :instrument = "instrument"/>
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
  data: () => ({
    instruments: [
      { city: 'istanbul', photos: [], name: 'Fender C100S', info: 'Test ediliyor', category: '', shop_name: 'Test Mağazası', open_to_sell: false, price: 35.5 },
      { city: 'istanbul', photos: [], name: 'Fender C100S', info: 'Test ediliyor', category: '', shop_name: 'Test Mağazası', open_to_sell: false, price: 35.5 },
      { city: 'istanbul', photos: [], name: 'Bender C100S', info: 'Aşırı yeni model', category: '', shop_name: 'Test Mağazası', open_to_sell: true, price: 150.9 }
    ]
  }),
  components: {
    instrumentCard,
    homeToolbar
  }
}
</script>
