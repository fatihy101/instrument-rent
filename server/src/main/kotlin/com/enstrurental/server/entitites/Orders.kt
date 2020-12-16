package com.enstrurental.server.entitites

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.sql.Timestamp
import javax.sound.midi.Instrument

@Document
data class Orders(
        @Id
        val id: Int,
        val order_date: Timestamp,
        val instrument: Instrument,
        val users : Users,
        val renters: Renters,
        val delivery_type: String,
        val address: Address,
        val total_rented_days: Int,
        val tracking_number: String?,
        val estimated_delivery_date : Timestamp?,
        val total_price: Double
        )
