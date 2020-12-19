package com.enstrurental.server.entitites

import org.bson.types.Binary
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.sql.Timestamp

@Document
data class Instruments(
        @Id
        val id: Int,
        var name: String,
        var category: String,
        var description: String?,
        val register_date: Timestamp = Timestamp(System.currentTimeMillis()),
        var availability: Boolean = true,
        var unavailable_due_date: Timestamp?,
        val price_by_day: Double,
        val deposit_price: Double,
        val photos: List<Binary>?,
        val open_to_sell: Boolean = false,
        val is_used: Boolean = false,
        var available_delivery_types : List<String>,
        var tags :List<String>

        )