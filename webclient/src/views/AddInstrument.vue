<template>
  <v-container fluid>
    <!-- Add Photos -->
    <v-row>
      <v-col v-for ="(element, index) in image_number" :key="index" class="d-flex justify-center">
        <photo @value="image_number += $event" :image_number="image_number" :index_no ="index"/>
      </v-col>
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
<!-- Todo: recommended rent price according to its full price (if it's available), format hint of deposit -->
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
         label="En fazla kaç gün kiralanabilir?"
         :hint="`En fazla ${newInstrument.max_rental_days} gün kiralanabilir.`"
         maxValue = "45"
         @selectedVal="newInstrument.max_rental_days = $event" />
      </v-col>
    <!-- /For rental -->
    </v-row>

      <!-- Deposit -->
   <transition name="slide">
    <v-row class="my-3 mx-4" v-if="newInstrument.is_rental">
      <v-col lg="2" md="2" sm="2">
        <v-checkbox label="Depozito Alınsın mı?" @change="depositPrice()" hint="Ürün geri verildiğinde, hasar yoksa iade edilir." persistent-hint
        class="mr-4" color="secondary" v-model="newInstrument.is_deposit_required"></v-checkbox>
      </v-col>
      <v-divider vertical class="mx-5"></v-divider>
      <v-col>
        <v-slider class="mt-2" :disabled="!newInstrument.is_deposit_required"
        persistent-hint
        ticks="always"
        tick-size="3"
        :hint="`Depozito tutarı, sadece günlük tutarın katları olarak arttırılabilir. Ücret: ${newInstrument.deposit_price} TL`"
        label="Depozito tutarı"
        color="secondary"
        :min="1"
        :max="10"
        v-model="deposit_multiplier"
        :hide-details="!newInstrument.is_deposit_required"
        @change="depositPrice()" >
        <template v-slot:append>
            <v-text-field
                readonly
                class="mt-0 pt-0"
                style="width: 30px"
                v-text="deposit_multiplier + 'x'"
            ></v-text-field>
        </template>
    </v-slider>
      </v-col>
    </v-row>
   </transition>
    <!-- /Deposit -->

    <v-divider class="my-6"></v-divider>

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
        <ThemeSlider label="Stoktaki Ürün Sayısı" v-model="newInstrument.stock_quantity" maxValue="100"
        :is_disabled="!newInstrument.is_open_to_sell" @selectedVal="newInstrument.stock_quantity = $event" />
      </v-col>
      <!-- /Expose for sale -->
    </v-row>
    <v-divider class="my-6"></v-divider>

    <v-row class="mx-5 mt-4">
      <v-textarea
          v-model="newInstrument.info"
          label="Ürünün açıklaması"
          value="The Woodman set to work at once, and so sharp was his axe that the tree was soon chopped nearly through."
          hint="Ürünün genel özelliklerini, kiralanabilen bir ürün ise firma olarak kiralama sürecinde nelere dikkat ettiğinizi yazabilirsiniz."
          outlined
        ></v-textarea>
    </v-row>
    <v-divider class="my-3"></v-divider>
    <v-row class="mx-15 mt-5">
      <!-- Is used -->
      <v-col>
        <Dropdown label="Sıfır mı?"
         :items="['Sıfır', 'İkinci El']"
         @selectedItem="newInstrument.is_used = isUsed($event)"
        />
      </v-col>
      <!-- /Is used -->
      <!-- Delivery types -->
      <v-col>
        <Dropdown
         label="Teslimat Türlerini seçiniz. (Birden fazla seçim yapılabilir.)"
         :chips="true"
         :multiple="true"
         @selectedItem="newInstrument.delivery_types = $event"
         :items="['Mağazadan Teslim Alma', 'Özel Teslimat', 'Kargo']" />
      </v-col>
      <!-- /Delivery types -->
    </v-row>
    <!-- Confirm Button -->
    <v-row class="my-4">
      <v-col lg="4" md="0"></v-col>
      <v-col lg="4" md="12" sm="12">
        <v-btn color="secondary" block style="color: black;" class="py-6" @click="showAll()">Onayla</v-btn>
      </v-col>
    </v-row>
    <!-- /Confirm Button -->
  </v-container>
</template>

<script>
import ThemeSlider from '../components/addInstrumentPage/ThemeSlider.vue'
import Dropdown from '../components/addInstrumentPage/Dropdown.vue'
import photo from '../components/addInstrumentPage/Photo.vue'

export default {
  name: 'AddInstrument',
  components: {
    Dropdown,
    ThemeSlider,
    photo
  },
  data: () => ({
    slider_val: 1,
    image_number: 1,
    deposit_multiplier: 1,
    category_items: ['Gitar', 'Elektro Gitar'],
    brands: ['Ibanez', 'Gibson', 'Fender'],
    photos: [],
    newInstrument: {
      category: '',
      brand: '',
      model: '',
      info: '',
      is_rental: true,
      is_deposit_required: false,
      is_open_to_sell: false,
      max_rental_days: 1,
      daily_price: null,
      full_price: null,
      deposit_price: null,
      stock_quantity: null,
      is_used: null,
      delivery_types: []
    }
  }),
  methods: {
    formatToFloat (value) {
      if (value.match(/[a-z]/i)) return 0
      else if (value.includes(',')) return parseFloat(value.replace(',', '.')).toFixed(2)
      else if (value % 1 === 0) return value
      else return parseFloat(value).toFixed(2)
    },
    depositPrice () {
      this.newInstrument.deposit_price = this.deposit_multiplier * this.newInstrument.daily_price
    },
    isUsed (arg) {
      console.info(arg)
      if (arg === 'Sıfır') return false
      else return true
    },
    showAll () {
      console.info(this.newInstrument.max_rental_days)
    }
  }
}
</script>

<style lang = "scss" scoped>

</style>
