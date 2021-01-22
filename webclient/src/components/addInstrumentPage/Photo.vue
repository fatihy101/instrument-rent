<template>
   <v-img
    @click="addImage()"
    height="250"
    max-width="30em"
    style="border: 1px solid; background-color:#25222A">
        <v-icon size="150px" class="center-item">mdi-plus</v-icon>
        <p class="image-text">FOTOĞRAF EKLE</p>
    </v-img>
</template>

<script>
export default {
  name: 'photo',
  props: { image_number: Number },
  data: () => ({
    max_photo: 4
  }),
  methods: {
    addImage () {
      if (this.image_number >= this.max_photo) {
        alert(`En fazla ${this.max_photo} tane fotoğraf ekleyebilirsiniz.`)
        this.$emit('value', 0)
      } else this.$emit('value', 1)
    }
  }

}
</script>

<style lang="scss" scoped>
.center-item {
  width: 100%;
  margin-top: 10px;
}
.image-text {
  text-align: center;
  font-weight: 700;
}

</style>
