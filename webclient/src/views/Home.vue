<template>
  <v-container>
    <v-toolbar class="mt-0 mx-0" color="primary" elevation="10">
        <!-- Buttons -->
        <v-btn text v-for="(button, index) in toolbar_buttons" :key="index"
          @click="handleFunctionCall(button.target_function)">
          {{ button.text }}
        </v-btn>
        <!-- /Buttons -->

        <v-spacer> </v-spacer>
        <!-- Possible Search Bar position -->
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
