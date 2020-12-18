package com.enstrurental.server.controllers

import com.enstrurental.server.entitites.UserRepository
import com.enstrurental.server.entitites.Users
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("users")
class UsersController(private val userRepository: UserRepository) {

    @GetMapping("/")
    fun getAllUsers() : Flux<Users> =  userRepository.findAll()

    @PostMapping("/save")
    fun saveUser(@RequestBody user: Users) : Mono<ResponseEntity<Users>> {
        return userRepository.save(user)
                .map{savedUser -> ResponseEntity.ok(savedUser)}
                .defaultIfEmpty(ResponseEntity.notFound().build())
    }

    @GetMapping("/{userId}")
    fun getUserById(@PathVariable userId: String) : Mono<ResponseEntity<Users>>{
        return userRepository.findById(userId)
                .map { user -> ResponseEntity.ok(user)}
                .defaultIfEmpty(ResponseEntity.notFound().build())
    }



// To fully configure response, use ResponseEntity. It represent the whole HTTP response (status code, body, header).



}