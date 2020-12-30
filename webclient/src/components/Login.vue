<template>

        <v-sheet rounded="lg" class="d-flex justify-center">
            <v-form lazy-validation>
            <v-text-field label="E-postanız"></v-text-field>
            <v-text-field label="Parolanız"></v-text-field>

                <v-btn color="primary" class="ml-5 my-5">
                Giriş Yap <v-icon>mdi-account</v-icon>
            </v-btn>
            <v-divider></v-divider>
            <v-btn color="accent" class="ml-5 my-5">
                Kayıt Ol <v-icon>mdi-account-plus</v-icon>
            </v-btn>
            </v-form>
        </v-sheet>
</template>

<script>
export default {
  name: 'Login'

}
</script>

<style>

</style>
