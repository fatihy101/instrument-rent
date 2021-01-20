<template>
  <v-slider class="mt-2" :disabled="is_disabled"
        persistent-hint
        :hint="`En fazla ${value} gün kiralanabilir.`"
        label="Maksimum kaç gün kiralanabilir?"
        color="secondary"
        :min="1"
        :max="45"
        v-model="value"
        :hide-details="is_disabled"
        @change="$emit('maxDays', value)" >
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
  name: 'daySlider',
  props: { is_disabled: Boolean },
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
