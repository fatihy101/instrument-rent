package com.enstrurental.server.controllers

import com.enstrurental.server.entitites.RenterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RestController
@RequestMapping("renters")
class RentersController(@Autowired private val renterRepository: RenterController) {

    @GetMapping("/")
    fun getAllRenters() : Flux<Renters> = renterRepository.findAll()

    @PostMapping("/update")
    fun Flux<Renters> updateRenter(@RequestBody Renters renter) {
        return renterRepository.updateRenters(renter)
                .map { updatedrenter -> ResponseEntitiy.ok(renter)}
                .defaultIfEmpty(ResponseEntity.notFound().build())


    @GetMapping("/{id}")
    private Mono<ResponseEntity<Renter>> getRenterById(@PathVariable String id) {
        return renterRepository.findRenterById(id)
                .map { renter -> ResponseEntitiy.ok(renter)}
                .defaultIfEmpty(ResponseEntity.notFound().build())


    }
    }

}
