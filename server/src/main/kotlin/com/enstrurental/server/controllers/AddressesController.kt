package com.enstrurental.server.controllers

import com.enstrurental.server.entitites.Addresses
import com.enstrurental.server.entitites.AddressesRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("addresses")
class AddressesController(val addressesRepository: AddressesRepository) {

    @GetMapping
    fun getAllAddresses() : Flux<Addresses> = addressesRepository.findAll()

}