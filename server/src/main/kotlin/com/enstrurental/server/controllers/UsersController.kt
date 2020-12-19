package com.enstrurental.server.controllers

import com.enstrurental.server.entitites.UsersRepository
import com.enstrurental.server.entitites.Users
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("users")
class UsersController(private val usersRepository: UsersRepository) {

    @GetMapping("/")
    fun getAllUsers() : Flux<Users> =  usersRepository.findAll()

    @GetMapping("/{userId}")
    fun getUserById(@PathVariable userId: String) : Mono<ResponseEntity<Users>>{
        return usersRepository.findById(userId)
                .map { user -> ResponseEntity.ok(user)}
                .defaultIfEmpty(ResponseEntity.notFound().build())
    }

    @PostMapping("/save")
    fun saveUser(@RequestBody user: Users) : Mono<ResponseEntity<Users>> {
        return usersRepository.save(user)
                .map{ savedUser -> ResponseEntity.ok(savedUser)}
                .defaultIfEmpty(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/delete/{id}")
    fun deleteUser(@PathVariable id: String): Mono<ResponseEntity<String>> = usersRepository.deleteById(id)
            .map { ResponseEntity.ok(" User deleted. ID: $id")}
            .defaultIfEmpty(ResponseEntity.notFound().build())


    @PutMapping("update_phone/{id}")
    fun updatePhoneNumber(@PathVariable id: String, @RequestBody user_updated: Users) : Mono<ResponseEntity<Users>>
    {
        return usersRepository.findById(id)
                .flatMap { user ->
                    user.phone_number = user_updated.phone_number
                    usersRepository.save(user)
                }
                .map { user -> ResponseEntity.ok(user) }
                .defaultIfEmpty(ResponseEntity(HttpStatus.NOT_FOUND))
    }


// To fully configure response, use ResponseEntity. It represent the whole HTTP response (status code, body, header).



}