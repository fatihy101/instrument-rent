package com.enstrurental.server.entitites

import java.util.*

data class CreditCard(

        val card_title: String,
        val card_no: String,
        val name_surname: String,
        val expiry_date: Date,
        val security_code: Int
)