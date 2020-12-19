package com.enstrurental.server.entitites

import java.util.*

// Note: This class is not necessary at this moment. It'll be important when we agree with a payment gateway.
data class CreditCard(

        val card_title: String,
        val card_no: String,
        val name_surname: String,
        val expiry_date: Date,
        val security_code: Int
)