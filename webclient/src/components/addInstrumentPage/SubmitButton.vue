<template>
  <div>
    <!-- Submit Button -->
    <v-btn
    color="secondary"
    block
    style="color: black;"
    class="py-6"
    :loading="isLoading"
    :disabled="productInformation === false"
    @click="validate()">Onayla</v-btn>
    <!-- /Submit Button -->

    <!-- dialog box -->
    <v-dialog
      v-model="dialog"
      scrollable
      max-width="400">
      <v-card>
        <!-- dialog box content -->
        <v-card-title>
          Aşağıdaki hataları gideriniz:
        </v-card-title>
        <v-card-text style="color: #333;">
          <ol>
            <li v-for="(error, index) in errors" :key="index" > {{ error }}</li>
          </ol>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="secondary darken-1"
            text
            @click="dialog = false">
            Tamam
          </v-btn>
        </v-card-actions>
        <!-- /dialog box content -->
      </v-card>
    </v-dialog>
    <!-- /dialog box -->
  </div>
</template>

<script>
// import axios from 'axios'
export default {
  name: 'SubmitButton',
  props: { productInformation: Object, photos: Array },
  data: () => ({
    dialog: false,
    isLoading: false,
    errors: []
  }),
  methods: {
    async sendData (product) {
      // TODO: Send data through the Axios.
      // await axios.post("http://localhost:4001/product/")
    },
    validate () {
      this.isLoading = true
      // Reset values.
      var product = this.productInformation
      this.errors = []
      // DATA PREPROCESS
      if (!product.is_rental) {
        product.daily_price = null
        product.max_rental_days = null
        product.is_deposit_required = false
        product.deposit_price = null
      } else if (!product.is_open_to_sell) {
        product.full_price = null
        product.stock_quantity = null
      }
      // CREATE ERRRORS
      // for rental products.
      if (product.is_rental) {
        if (product.daily_price === null) this.errors.push('Ürünün günlük fiyatını belirtiniz.')
        if (product.max_rental_days === null) this.errors.push('Ürünün maksimum kaç gün kullanılacağını belirtiniz.')
        if (product.is_deposit_required && product.deposit_price === null) this.errors.push('Ürünün depozito fiyatını belirleyiniz.')
      }
      // for open to sell products.
      if (product.is_open_to_sell && product.full_price == null) this.errors.push('Ürünün satış fiyatını belirtiniz.')
      if (product.is_open_to_sell && product.stock_quantity == null) this.errors.push('Stoktaki ürün sayısını belirtiniz.')
      // Other fields.
      if (this.photos.length === 0) this.errors.push('Ürünün en az 1 tane fotoğrafını yükleyiniz.')
      if (!product.is_rental && !product.is_open_to_sell) this.errors.push('"Kiraya ver" ve/veya "satışa çıkar"ı işaretleyiniz.')
      if (product.category === '') this.errors.push('Ürünün kategorisini seçiniz.')
      if (product.brand === '') this.errors.push('Ürünün markasını seçiniz.')
      if (product.info === '') {
        this.errors.push('Ürünün açıklamasını giriniz.')
      } else if (product.info.length < 10) this.errors.push('Ürünün açıklaması çok kısa.')
      if (product.is_used === null) this.errors.push('Ürün sıfır mı yoksa ikinci el mi belirtiniz.')
      if (product.delivery_types.length === 0) this.errors.push('Teslimat türlerini seçiniz.')

      if (this.errors.length > 0) this.dialog = true // If there's errors, activate the dialog box
      else this.sendData(product)

      this.isLoading = false
    }
  }
}
</script>
