package com.enstrurental.server.entitites

import org.bson.types.Binary
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.sql.Timestamp

@Document
data class Orders(
        @Id
        val id: Int,
        val order_date: Timestamp = Timestamp(System.currentTimeMillis()),
        val instrument: Instruments,
        val user : Clients,
        val renter: Renters,
        var delivery_type: String,
        var address: Addresses,
        var is_rental: Boolean = true,
        var initial_photos: List<Binary>?,
        var last_photos: List<Binary>?,
        var total_rented_days: Int?,
        var tracking_number: String?,
        var estimated_delivery_date : Timestamp?,
        val total_price: Double
        )
