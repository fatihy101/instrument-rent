package com.enstrurental.server.entitites

import org.bson.types.Binary
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.sql.Timestamp

@Document
data class Clients (
        @Id
        val id: String,
        val registration_date: Timestamp = Timestamp(System.currentTimeMillis()),
        var email: String,
        var name: String,
        var surname: String,
        var phone_number: String,
        var profile_picture: Binary?
        )