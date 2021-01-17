package com.enstrurental.server.controllers

import com.enstrurental.server.entitites.AllUsers
import com.enstrurental.server.entitites.AllUsersRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("all_users_types")
class AllUsersController (private val allUsersRepository: AllUsersRepository) {

    @CrossOrigin
    @PostMapping("save")
    fun saveUser(@RequestBody user : AllUsers): Mono<String> =
        allUsersRepository.save(user)
        .map {_ -> "Done" }.onErrorMap { error -> error("ERROR: $error") }

    @CrossOrigin
    @GetMapping("{uid}")
    fun getUserById (@PathVariable uid: String) : Mono<ResponseEntity<String>> {
        return allUsersRepository.findById(uid)
            .map { user -> ResponseEntity.ok(user.type) }
            .defaultIfEmpty(ResponseEntity.notFound().build())
    }
}