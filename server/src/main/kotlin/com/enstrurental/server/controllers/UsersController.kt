package com.enstrurental.server.controllers

import com.enstrurental.server.entitites.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("users")
class UsersController(@Autowired private val userRepository: UserRepository) {

}