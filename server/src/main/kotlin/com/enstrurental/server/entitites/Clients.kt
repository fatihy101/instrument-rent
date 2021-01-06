package com.enstrurental.server.entitites

import org.bson.types.Binary
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Document
data class Clients (
        @Id
        val id: String?,
        @CreatedDate
        val registration_date: LocalDateTime? = LocalDateTime.now(),
        val birthday_date: LocalDateTime,
        var email: String?,
        var name: String?,
        var surname: String?,
        var phone_number: String?,
        var profile_picture: Binary?
        )