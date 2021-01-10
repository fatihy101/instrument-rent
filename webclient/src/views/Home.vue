<template>
  <v-container>
    <v-toolbar class="mt-0 mx-0" color="secondary" light elevation="10">
        <!-- Buttons -->
        <v-btn text v-for="(button, index) in toolbar_buttons" :key="index"
          @click="handleFunctionCall(button.target_function)">
          {{ button.text }}
        </v-btn>
        <!-- /Buttons -->

        <v-spacer> </v-spacer>
        <!-- Possible Search Bar position -->
          <v-text-field
            solo-inverted
            id="search-bar"
            class="shrink"
            label="Enstrüman Ara"
            append-icon="mdi-magnify"
          ></v-text-field>
    </v-toolbar>
    <instrumentCard />
  </v-container>
</template>

<script>
// @ is an alias to /src
import instrumentCard from '@/components/instrumentCard.vue'

export default {
  name: 'Home',
  data: () => ({
    toolbar_buttons: [
      { text: 'Test', target_function: 'test' },
      { text: 'Test', target_function: 'test' },
      { text: 'Test', target_function: 'test' }
    ]
  }),
  components: {
    instrumentCard
  },
  methods: {
    // Redirector function.
    handleFunctionCall (func) {
      if (func === 'test') this.test()
    },
    test () {
      alert('Works!')
    }
  }
}
</script>

<style lang="scss" scoped>
.v-text-field {
  width:300px;
  height: 48px;
  background-color: #C0B5AF;
  color: white;
}
</style>
