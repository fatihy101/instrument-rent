package com.enstrurental.server.entitites

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Addresses(
        @Id
        val address_id: Int,
        var address_title: String,
        var city: String,
        var state: String,
        var zipcode: Int?,
        var street: String,
        var building_no: String,
        var description: String

)