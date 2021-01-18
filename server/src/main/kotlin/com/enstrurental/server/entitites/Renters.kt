package com.enstrurental.server.entitites

import org.bson.types.Binary
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Renters (
        @Id
        val id: String?,
        @CreatedDate
        val registration_date: LocalDateTime? = LocalDateTime.now(),
        var name: String?,
        var surname: String?,
        var email: String?,
        var info: String?,
        var shop_name: String?,
        var phone_number: String?,
        var shop_geolocation : Geolocation?, // TODO: Research the common type for geolocations in Kotlin or Java.
        var rating: Double?,
        var profile_picture: String?,
        var header_picture: String?
)

data class Geolocation(val lat: String, val long: String)