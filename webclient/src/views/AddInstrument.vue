<template>
  <v-container fluid>
    <!-- Add Photos -->
    <v-row>
      <v-col v-for ="element in image_number" :key="element" class="d-flex justify-center">
        <v-img
        height="250"
        max-width="30em"
        style="border: 1px solid; background-color:#25222A">
          <v-icon size="150px" class="center-item">mdi-plus</v-icon>
          <p class="image-text">FOTOĞRAF EKLE</p>
        </v-img>
      </v-col>
      <!-- Max 4 photos, generate a box after uploading a photo. -->
    </v-row>
    <!-- /Add Photos -->

    <v-row class="mt-5 mx-5">
      <!-- Brand, category, model -->
      <v-col>
        <Dropdown label="Marka" :items="brands" @selectedItem="newInstrument.brand = $event" />
      </v-col>
      <v-col>
        <Dropdown label="Kategori" :items="category_items" @selectedItem="newInstrument.category = $event" />
      </v-col>
      <v-col>
        <v-text-field label="Modeli (Varsa)" solo light background-color="secondary" v-model="newInstrument.model"></v-text-field>
      </v-col>
      <!-- /Brand, category, model -->

    </v-row>
<!-- Todo: infobox, delivery types: special delivery or hands-on, used or not, recommended rent price according to its full price (if it's available), convert float prices -->
    <v-divider></v-divider>
    <v-row class="my-3 mx-4">
    <!-- For rental -->
      <v-col lg="2" md="2" sm="2">
        <v-checkbox label="Kiraya Ver" class="mr-4" color="secondary" v-model="newInstrument.is_rental"></v-checkbox>
      </v-col>
      <v-divider vertical class="mx-5"></v-divider>
      <v-col  lg="2" md="2" sm="2">
        <v-text-field label="Günlük Kira Bedeli" v-model="newInstrument.daily_price"
          @change="newInstrument.daily_price = formatToFloat(newInstrument.daily_price)"
         :disabled="!newInstrument.is_rental"
         append-icon="mdi-currency-try" ></v-text-field>
      </v-col>
      <v-divider vertical class="mx-5"></v-divider>
      <v-col>
        <ThemeSlider :is_disabled="!newInstrument.is_rental"
         label="Maksimum kaç gün kiralanabilir?"
         :hint="`En fazla ${newInstrument.max_rental_days} gün kiralanabilir.`"
         maxValue = "45"
         @selectedVal="newInstrument.max_rental_days = $event" />
      </v-col>
    <!-- /For rental -->
    </v-row>

    <v-row class="my-3 mx-4">
      <!-- Expose for sale -->
      <v-col lg="2" md="2" sm="2">
        <v-checkbox label="Satışa Çıkar" class="mr-4" color="secondary" v-model="newInstrument.is_open_to_sell"></v-checkbox>
      </v-col>
      <v-divider vertical class="mx-5"></v-divider>
      <v-col  lg="2" md="2" sm="2">
        <v-text-field label="Birim Fiyatı" v-model="newInstrument.full_price"
         @change="newInstrument.full_price = formatToFloat(newInstrument.full_price)"
         append-icon="mdi-currency-try"
         :disabled="!newInstrument.is_open_to_sell">
        </v-text-field>
      </v-col>
      <v-divider vertical class="mx-5"></v-divider>
      <v-col>
        <ThemeSlider label="Stoktaki Ürün Sayısı" v-model="newInstrument.quantity"
        :is_disabled="!newInstrument.is_open_to_sell" @selectedVal="newInstrument.quantity = $event" />
      </v-col>
      <!-- /Expose for sale -->
    </v-row>
    <v-divider class="my-6"></v-divider>

    <v-row>
      <!-- infobox -->
    </v-row>
    <v-row class="mx-10 my-4">
      <v-btn color="secondary darken-1" block style="color: black;">Onayla</v-btn>
    </v-row>

  </v-container>
</template>

<script>
import ThemeSlider from '../components/addInstrumentPage/ThemeSlider.vue'
import Dropdown from '../components/addInstrumentPage/Dropdown.vue'

export default {
  name: 'AddInstrument',
  components: {
    Dropdown,
    ThemeSlider
  },
  data: () => ({
    slider_val: 1,
    image_number: 1,
    category_items: ['Gitar', 'Elektro Gitar'],
    brands: ['Ibanez', 'Gibson', 'Fender'],
    newInstrument: {
      category: '',
      brand: '',
      model: '',
      is_rental: true,
      is_open_to_sell: false,
      max_rental_days: 1,
      daily_price: null,
      full_price: null,
      quantity: null
    }
  }),
  methods: {
    formatToFloat (value) {
      if (value.match(/[a-z]/i)) return 0
      else if (value.includes(',')) return parseFloat(value.replace(',', '.')).toFixed(2)
      else if (value % 1 === 0) return value
      else return parseFloat(value).toFixed(2)
    }
  }
}
</script>

<style lang = "scss" scoped>
.center-item {
  width: 100%;
  margin-top: 10px;
}
.image-text {
  text-align: center;
  font-weight: 700;
}

</style>
