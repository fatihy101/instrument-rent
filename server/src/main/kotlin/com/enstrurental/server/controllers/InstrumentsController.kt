package com.enstrurental.server.controllers

import com.enstrurental.server.entitites.Instruments
import com.enstrurental.server.entitites.InstrumentsRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
@RestController
@RequestMapping("instruments")

class InstrumentsController(val instrumentsRepository: InstrumentsRepository) {

    @GetMapping("/")
    fun getAllInstruments() : Flux<Instruments> =  instrumentsRepository.findAll() // Todo: Order by added_date

}