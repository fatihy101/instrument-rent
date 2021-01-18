package com.enstrurental.server.entitites

import com.fasterxml.jackson.annotation.JsonFormat
import org.bson.types.Binary
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Document
data class Clients (
        @Id
        val id: String?,
        @CreatedDate
        val registration_date: LocalDateTime? = LocalDateTime.now(),
        @JsonFormat(pattern = "dd-MM-yyyy")
        var birthday_date: LocalDate?,
        var email: String?,
        var name: String?,
        var surname: String?,
        var phone_number: String?,
        var profile_picture: String?
        )