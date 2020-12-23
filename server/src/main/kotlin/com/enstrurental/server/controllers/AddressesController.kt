package com.enstrurental.server.controllers

import com.enstrurental.server.entitites.Addresses
import com.enstrurental.server.entitites.AddressesRepository
import com.enstrurental.server.entitites.Clients
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
/* Tested
TODO: add update address*/

@RestController
@RequestMapping("addresses")
class AddressesController(val addressesRepository: AddressesRepository) {

    @GetMapping("/")
    fun getAllAddresses() : Flux<Addresses> = addressesRepository.findAll()

    @PostMapping("/save")
    fun createAddress(@RequestBody address: Addresses) : Mono<ResponseEntity<Addresses>> {
        return addressesRepository.save(address)
                .map{ savedAddress -> ResponseEntity.ok(savedAddress)}
                .defaultIfEmpty(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/delete/{id}")
    fun deleteAddress(@PathVariable id: Int): Mono<ResponseEntity<String>> = addressesRepository.deleteById(id)
            .map { ResponseEntity.ok(" Client deleted. ID: $id")}
            .defaultIfEmpty(ResponseEntity.notFound().build())


    @GetMapping("/{uid}")
    fun getAddressesByUid(@PathVariable uid: String): Flux<Addresses>{

        return addressesRepository.findAddressesByUid(uid)
    }



}