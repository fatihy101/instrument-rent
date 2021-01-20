<template>
  <v-slider class="mt-2" :disabled="is_disabled"
        persistent-hint
        :hint="hint"
        :label="label"
        color="secondary"
        :min="1"
        :max="maxValue"
        v-model="value"
        :hide-details="is_disabled"
        @change="$emit('selectedVal', value)" >
        <template v-slot:append>
            <v-text-field
                @change="checkVal()"
                v-model="value"
                class="mt-0 pt-0"
                style="width: 30px"
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
      if (isNaN(this.value)) this.value = 1
    }
  }
}
</script>

<style>

</style>
