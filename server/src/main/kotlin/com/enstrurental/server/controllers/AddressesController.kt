package com.enstrurental.server.controllers

import com.enstrurental.server.entitites.Addresses
import com.enstrurental.server.entitites.AddressesRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
/* Tested
TODO: add update address*/

@RestController
@RequestMapping("addresses")
@CrossOrigin(origins = ["http://localhost:8080"])
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

    @PutMapping("/{id}/update_title/")
    fun updateTitle(@PathVariable id: Int, @RequestBody address_updated: Addresses) : Mono<ResponseEntity<Addresses>>
    {
        return addressesRepository.findById(id)
            .flatMap { address ->
                address.title = address_updated.title
                addressesRepository.save(address)
            }
            .map { address -> ResponseEntity.ok(address) }
            .defaultIfEmpty(ResponseEntity(HttpStatus.NOT_FOUND))
    }

    @PutMapping("/{id}/update_city/")
    fun updateCity(@PathVariable id: Int, @RequestBody address_updated: Addresses) : Mono<ResponseEntity<Addresses>>
    {
        return addressesRepository.findById(id)
            .flatMap { address ->
                address.city = address_updated.city
                addressesRepository.save(address)
            }
            .map { address -> ResponseEntity.ok(address) }
            .defaultIfEmpty(ResponseEntity(HttpStatus.NOT_FOUND))
    }

    @PutMapping("/{id}/update_state/")
    fun updateState(@PathVariable id: Int, @RequestBody address_updated: Addresses) : Mono<ResponseEntity<Addresses>>
    {
        return addressesRepository.findById(id)
            .flatMap { address ->
                address.state = address_updated.state
                addressesRepository.save(address)
            }
            .map { address -> ResponseEntity.ok(address) }
            .defaultIfEmpty(ResponseEntity(HttpStatus.NOT_FOUND))
    }

    @PutMapping("/{id}/update_zipcode/")
    fun updateZipcode(@PathVariable id: Int, @RequestBody address_updated: Addresses) :
            Mono<ResponseEntity<Addresses>>
    {
        return addressesRepository.findById(id)
            .flatMap { address ->
                address.zipcode = address_updated.zipcode
                addressesRepository.save(address)
            }
            .map { address -> ResponseEntity.ok(address) }
            .defaultIfEmpty(ResponseEntity(HttpStatus.NOT_FOUND))
    }

    @PutMapping("/{id}/update_street/")
    fun updateStreet(@PathVariable id: Int, @RequestBody address_updated: Addresses) : Mono<ResponseEntity<Addresses>>
    {
        return addressesRepository.findById(id)
            .flatMap { address ->
                address.street = address_updated.street
                addressesRepository.save(address)
            }
            .map { address -> ResponseEntity.ok(address) }
            .defaultIfEmpty(ResponseEntity(HttpStatus.NOT_FOUND))
    }

    @PutMapping("/{id}/update_building_no/")
    fun updateBuildingNo(@PathVariable id: Int, @RequestBody address_updated: Addresses) : Mono<ResponseEntity<Addresses>>
    {
        return addressesRepository.findById(id)
            .flatMap { address ->
                address.building_no = address_updated.building_no
                addressesRepository.save(address)
            }
            .map { address -> ResponseEntity.ok(address) }
            .defaultIfEmpty(ResponseEntity(HttpStatus.NOT_FOUND))
    }

    @PutMapping("/{id}/update_description/")
    fun updateDescription(@PathVariable id: Int, @RequestBody address_updated: Addresses) : Mono<ResponseEntity<Addresses>>
    {
        return addressesRepository.findById(id)
            .flatMap { address ->
                address.description = address_updated.description
                addressesRepository.save(address)
            }
            .map { address -> ResponseEntity.ok(address) }
            .defaultIfEmpty(ResponseEntity(HttpStatus.NOT_FOUND))
    }

}