<template>
  <v-menu
    ref="menu"
    v-model="menu"
    :close-on-content-click="false"
    transition="scale-transition"
    offset-y
    min-width="290px"
  >
    <template v-slot:activator="{ on, attrs }">
      <v-text-field
        v-model="date"
        label="Doğum günü tarihi"
        readonly
        v-bind="attrs"
        v-on="on"
      ></v-text-field>
    </template>
    <v-date-picker
      ref="picker"
      v-model="date"
      :max="maxDate"
      min="1920-01-01"
      @change="save"
    ></v-date-picker>
  </v-menu>
</template>

<script>
export default {
  name: 'birthdayPicker',
  data: () => ({
    date: null,
    menu: false
  }),
  watch: {
    menu (val) {
      val && setTimeout(() => (this.$refs.picker.activePicker = 'YEAR'))
    }
  },
  methods: {
    save (date) {
      this.$refs.menu.save(date)
      this.$emit('birthdayDateChange', date)
    }
  },
  computed: {
    maxDate () {
      var maxYear = new Date()
      maxYear.setFullYear(maxYear.getFullYear() - 18)
      return maxYear.toISOString().substr(0, 10)
    }
  }
}
</script>
