<template>
  <v-card
  light
  color="secondary"
   class="mx-auto my-5 d-flex justify-center"
   height="325"
   min-width="500">
    <v-container>
        <v-row>
            <v-col>
                <v-img
                height="300"
                width="400"
                src="https://via.placeholder.com/300">
                </v-img>
            </v-col>

            <v-col>
                <v-card-title>{{ instrument.name }}</v-card-title>
                <p> {{ instrument.info }} </p>
            </v-col>

        </v-row>
    </v-container>

  </v-card>
</template>

<script>
export default {
  name: 'instrumentCard',
  data: () => ({
    instrument: {
      renter_public_uid: '',
      photos: [],
      name: 'Fender C100S',
      info: 'Test ediliyor',
      category: '',
      shop_name: '',
      open_to_sell: null,
      price: null
    }
  })
}
</script>

<style>

</style>
