<template>
    <v-combobox
          :label="label"
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
  props: { items: Array, label: String },
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
