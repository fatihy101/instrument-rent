package com.enstrurental.server.controllers

import com.enstrurental.server.entitites.Instruments
import com.enstrurental.server.entitites.InstrumentsRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("instruments")
@CrossOrigin(origins = ["http://localhost:8080"])
class InstrumentsController(val instrumentsRepository: InstrumentsRepository) {

    @GetMapping("/")
    fun getAllInstruments() : Flux<Instruments> =  instrumentsRepository.findAll() // Todo: Order by added_date

    @GetMapping("/{category}")
    fun getByCategory(@PathVariable category: String) : Flux<Instruments>{
        return instrumentsRepository.findInstrumentsByCategory(category)
    }

    @PostMapping("/create")
    fun createInstrument(@RequestBody instrument : Instruments): Mono<ResponseEntity<Instruments>>
    = instrumentsRepository.save(instrument)
            .map { response -> ResponseEntity.ok(response) }
            .defaultIfEmpty(ResponseEntity.notFound().build())

    @DeleteMapping("/delete/{id}")
    fun deleteInstrument(@PathVariable id: String): Mono<ResponseEntity<String>> = instrumentsRepository.deleteById(id)
            .map { ResponseEntity.ok(" Instrument deleted. ID: $id")}
            .defaultIfEmpty(ResponseEntity.notFound().build())

}