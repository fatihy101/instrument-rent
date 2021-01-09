package com.enstrurental.server

import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class TestController {

    @GetMapping(path = ["/numbers"])
    fun getNumbers() = Flux.range(1, 100)

    @GetMapping("/hello")
    fun helloKotlin(): String {
        return "hello world"
    }
    @GetMapping("")
    fun index(): Mono<String> {
        return Mono.just("Enstrurent Rest API is serving...")
    }
}