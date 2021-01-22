<template>
    <v-combobox
          :label="label"
          :multiple="multiple"
          :chips="chips"
          hide-selected
          solo
          light
          background-color="secondary"
          v-model="selected"
          :items="items"
          @change="selectedItem()"
        >
    </v-combobox>
</template>

<script>
export default {
  name: 'dropdown',
  props: { items: Array, label: String, multiple: Boolean, chips: Boolean },
  data: () => ({
    selected: null
  }),
  methods: {
    selectedItem () {
      this.$emit('selectedItem', this.selected)
    }
  }
}
</script>
