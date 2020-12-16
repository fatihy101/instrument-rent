package com.enstrurental.server.entitites

import org.bson.types.Binary
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.sql.Timestamp

@Document
data class Instruments(
        @Id
        val id: Int,
        val name: String,
        val category: String,
        val description: String,
        val added_date: Timestamp,
        val rent_start: Timestamp?,
        val rent_end: Timestamp?,
        val availability: Boolean,
        val price_daily: Double,
        val deposit_price: Double,
        val photos: List<Binary>,
        val is_rentable: Boolean = true,
        val is_used: Boolean = false,
        val delivery_types : List<String>,
        val tags :List<String>

        )