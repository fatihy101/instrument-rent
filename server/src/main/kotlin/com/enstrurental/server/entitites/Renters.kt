package com.enstrurental.server.entitites

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.sql.Timestamp

@Document
data class Renters (
        @Id
        val id: String,
        val registration_date: Timestamp = Timestamp(System.currentTimeMillis()),
        var email: String,
        var shop_name: String,
        val name: String,
        val surname: String,
        var phone_number: String,
        var shop_geolocation : String?, // TODO: Research the common type for geolocations in Kotlin or Java.
        val rating: Double?,
        val info: String
)