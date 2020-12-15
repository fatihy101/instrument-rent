package com.enstrurental.server.entitites

data class Address(
        val address_id: Int,
        val address_title: String,
        val city: String,
        val state: String,
        val zipcode: Int?,
        val street: String,
        val building_no: String,
        val description: String

)