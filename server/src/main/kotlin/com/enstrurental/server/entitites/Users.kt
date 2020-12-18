package com.enstrurental.server.entitites

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Users (
        @Id
        val id: String,
        val email: String,
        val name: String,
        val surname: String,
        val address: Address?,
        val phone_number: String,
        val credit_card : CreditCard?
        )