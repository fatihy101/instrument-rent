package com.enstrurental.server.controllers

import com.enstrurental.server.entitites.ClientsRepository
import com.enstrurental.server.entitites.Clients
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("clients")
class ClientsController(private val clientsRepository: ClientsRepository) {

    @GetMapping("/")
    fun getAllClients() : Flux<Clients> =  clientsRepository.findAll()

    @CrossOrigin
    @GetMapping("/{clientId}")
    fun getClientById(@PathVariable clientId: String) : Mono<ResponseEntity<Clients>>{
        return clientsRepository.findById(clientId)
            .map { client -> ResponseEntity.ok(client)}
            .defaultIfEmpty(ResponseEntity.notFound().build())
    }

    @CrossOrigin
    @PostMapping("/save")
    fun saveClient(@RequestBody client: Clients) : Mono<ResponseEntity<Clients>> {
        return clientsRepository.save(client)
                .map{ savedClient -> ResponseEntity.ok(savedClient)}
                .defaultIfEmpty(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/delete/{id}")
    fun deleteClient(@PathVariable id: String): Mono<ResponseEntity<String>> = clientsRepository.deleteById(id)
            .map { ResponseEntity.ok(" Client deleted. ID: $id")}
            .defaultIfEmpty(ResponseEntity.notFound().build())

    @CrossOrigin
    @PutMapping("/{id}/update_phone/")
    fun updatePhoneNumber(@PathVariable id: String, @RequestBody client_updated: Clients) : Mono<ResponseEntity<Clients>>
    {
        return clientsRepository.findById(id)
                .flatMap { client ->
                    client.phone_number = client_updated.phone_number
                    clientsRepository.save(client)
                }
                .map { client -> ResponseEntity.ok(client) }
                .defaultIfEmpty(ResponseEntity(HttpStatus.NOT_FOUND))
    }


// To fully configure response, use ResponseEntity. It represent the whole HTTP response (status code, body, header).



}