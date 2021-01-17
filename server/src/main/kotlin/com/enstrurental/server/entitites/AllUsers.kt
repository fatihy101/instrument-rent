package com.enstrurental.server.entitites

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class AllUsers (@Id val uid: String, val type: String)