<template>
  <v-card
  light
  color="secondary"
   class="mx-auto mt-5 d-flex justify-center"
   min-height="510"
   width="400">
    <v-container>
        <v-row>
            <v-col>
                <v-img
                height="300"
                width="400"
                src="https://via.placeholder.com/300">
                </v-img>
            </v-col>
        </v-row>
        <v-row>
            <v-col>
                <v-card-title>{{ instrument.name }}</v-card-title>
                <p> {{ instrument.info }} </p>
                <p><b> {{instrument.price}} TL </b></p>
                <v-btn block color="primary darken-1"> {{ buttonText }}  </v-btn>
            </v-col>
        </v-row>

    </v-container>

  </v-card>
</template>

<script>
export default {
  name: 'instrumentCard',
  props: ['instrument'],
  computed: {
    buttonText () {
      return this.instrument.open_to_sell ? 'Satın Al' : 'Kirala'
    }
  }
}
</script>

<style>

</style>
