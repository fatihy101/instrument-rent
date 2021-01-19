<template>
  <v-container>
    <!-- Add Photos -->
    <v-row>
      <v-col v-for ="element in 4" :key="element">
        <v-img
        height="250"
        max-width="30em"
        src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
        ></v-img>
      </v-col>
      <!-- Max 4 photos, generate a box after uploading a photo. -->
    </v-row>
    <!-- /Add Photos -->

    <!-- Name, brand -->
    <v-row>

    </v-row>
    <!-- /Name brand  -->

    <!-- Category -->
    <v-row>
      <!-- Combobox, dropdown -->
    </v-row>
    <!-- /Category -->

    <v-row>
      <!-- confirm button -->
    </v-row>

  </v-container>
</template>

<script>
export default {
  name: 'AddInstrument'

}
</script>

<style>

</style>
