package com.enstrurental.server.entitites

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Addresses(
        @Id
        val id: Int?,
        val uid: String?,
        var title: String?,
        var city: String?,
        var state: String?,
        var zipcode: Int?,
        var street: String?,
        var building_no: String?,
        var description: String?

)