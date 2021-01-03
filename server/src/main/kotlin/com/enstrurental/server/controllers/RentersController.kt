package com.enstrurental.server.controllers

import com.enstrurental.server.entitites.Renters
import com.enstrurental.server.entitites.RentersRepository
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/* [UNTESTED] TODO: Test */
@RestController
@RequestMapping("renters")
@CrossOrigin(origins = ["http://localhost:8080"])

class RentersController(private val rentersRepository: RentersRepository) {

    @GetMapping("/")
    fun getAllRenters() : Flux<Renters> = rentersRepository.findAll()

    @PostMapping("/save")
    fun  updateRenterInfo(@RequestBody renter : Renters) : Mono<ResponseEntity<Renters>> {
        return rentersRepository.save(renter)
                .map { ResponseEntity.ok(renter) }
                .defaultIfEmpty(ResponseEntity.notFound().build())
    }

    @GetMapping("/{id}")
    fun getRenterById(@PathVariable id: String) : Mono<ResponseEntity<Renters>> {
        return rentersRepository.findById(id)
                .map { renter -> ResponseEntity.ok(renter)}
                .defaultIfEmpty(ResponseEntity.notFound().build())
    }


}
