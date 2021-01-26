<template>
  <div class="wrapper-div">
    <input ref="fileInput" @change="onFileChange" type="file" style="display: none;" accept=".jpg, .jpeg, .png"/>
    <v-img v-if="!selectedPhoto"
      @click="selectImage"
      height="250"
      max-width="30em"
      style="border: 1px solid; background-color:#25222A">
      <v-icon size="150px" class="center-item">mdi-plus</v-icon>
      <p class="image-text">FOTOĞRAF EKLE</p>
    </v-img>
    <v-img v-else
      @click="changeImage"
      height="250"
      max-width="30em"
      style="border: 1px solid; background-color:#25222A" :src="url">
    </v-img>
    <p class="d-flex justify-center" style="color: #888;">
      {{ index_no + 1 }}
    </p>
  </div>
</template>

<script>
export default {
  name: 'photo',
  props: { image_number: Number, index_no: Number },
  data: () => ({
    max_block: 4,
    selectedPhoto: null,
    url: null
  }),
  methods: {
    selectImage () {
      if (this.image_number >= this.max_block) {
        this.$refs.fileInput.click()
        this.$emit('value', 0)
      } else {
        this.$refs.fileInput.click()
      }
    },
    onFileChange () {
      if (this.selectedPhoto) {
        this.selectedPhoto = event.target.files[0]
        this.url = URL.createObjectURL(this.selectedPhoto)
        this.$emit('getPhoto', { ref_id: this.index_no, photo: this.selectedPhoto })
      } else {
        this.selectedPhoto = event.target.files[0]
        this.url = URL.createObjectURL(this.selectedPhoto)
        this.$emit('getPhoto', { ref_id: this.index_no, photo: this.selectedPhoto })
        if (this.image_number < this.max_block) this.$emit('value', 1)
      }
    },
    changeImage () {
      this.$refs.fileInput.click()
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

.wrapper-div {
  width: 100%;
  max-width: 30em;
  height: 250px;
}
</style>
