package com.enstrurental.server.entitites

import org.bson.types.Binary
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.sql.Timestamp
import java.time.LocalDateTime

@Document
data class Orders(
        @Id
        val id: Int,
        @CreatedDate
        val order_date: LocalDateTime = LocalDateTime.now(),
        val instrument: Instruments,
        val client : Clients,
        val renter: Renters,
        var delivery_type: String,
        var address: Addresses,
        var is_rental: Boolean = true,
        var initial_photos: List<String>?,
        var last_photos: List<String>?,
        var total_rented_days: Int?,
        var tracking_number: String?,
        var estimated_delivery_date : Timestamp?,
        val total_price: Double,
        var archive: Boolean = false
        )
