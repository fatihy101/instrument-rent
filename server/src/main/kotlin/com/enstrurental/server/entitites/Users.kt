package com.enstrurental.server.entitites

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.sql.Timestamp

@Document
data class Users (
        @Id
        val id: String,
        val registration_date: Timestamp = Timestamp(System.currentTimeMillis()),
        var email: String,
        var name: String,
        var surname: String,
        var addresses: Addresses?,
        var phone_number: String,
        )