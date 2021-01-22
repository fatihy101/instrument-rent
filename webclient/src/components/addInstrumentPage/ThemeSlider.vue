<template>
  <v-slider
    class="mt-2"
    :disabled="is_disabled"
    persistent-hint
    :hint="formatHint"
    :label="label"
    color="secondary"
    :min="1"
    :max="maxValue"
    v-model="value"
    :hide-details="is_disabled"
    @change="checkVal()" >
    <template v-slot:append>
        <v-text-field
            @change="checkVal()"
            class="mt-0 pt-0"
            style="width: 30px"
            v-model="value"
        ></v-text-field>
    </template>
</v-slider>
</template>

<script>
export default {
  name: 'themeSlider',
  props: { is_disabled: Boolean, hint: String, label: String, maxValue: String },
  data: () => ({
    value: null
  }),
  methods: {
    checkVal () {
      if (isNaN(this.value)) {
        this.value = 1
      } else if (this.value > this.maxValue) this.value = this.maxValue
      this.$emit('selectedVal', this.value)
    }
  },
  computed: {
    formatHint () {
      return this.hint === undefined ? `Maksimum değer: ${this.maxValue}` : `${this.hint} Maksimum değer: ${this.maxValue}`
    }
  }
}
</script>

<style>

</style>
