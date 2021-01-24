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
  </div>
<!-- TODO: Return a JSON to parent -> { ref_id: String, photo: Binary }. Then add this JSON to photos[]. -->
<!-- If an added photo changes, search by ref_id; OPTION 1: DELETE whole old JSON, insert new one. OPTION 2: Just change photo data with new one.  -->
</template>

<script>
export default {
  name: 'photo',
  props: { image_number: Number, index_no: Number },
  data: () => ({
    max_block: 5,
    selectedPhoto: null,
    url: null
  }),
  mounted () {
    console.log('index_no: ' + this.index_no)
  },
  methods: {
    selectImage () {
      if (this.image_number >= this.max_block) {
        alert(`En fazla ${this.max_block} tane fotoğraf ekleyebilirsiniz.`)
        this.$emit('value', 0)
      } else {
        this.$refs.fileInput.click()
      }
    },
    onFileChange () {
      this.selectedPhoto = event.target.files[0]
      if (this.selectedPhoto) { // If photo isn't selected, don't run.
        this.url = URL.createObjectURL(this.selectedPhoto)
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
