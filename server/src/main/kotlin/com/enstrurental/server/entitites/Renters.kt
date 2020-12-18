package com.enstrurental.server.entitites

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Renters (
        @Id
        val id: String,
        val email: String,
        val shop_name: String,
        val name: String,
        val surname: String,
        val address: Address?,
        val phone_number: String,
        val credit_card : CreditCard?,
        val rating: Double?,
        val info: String
)