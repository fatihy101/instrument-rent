package com.enstrurental.server

import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
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

    @GetMapping("/mono-data")
    fun monoData() : Mono<String>
    {
        return Mono.just("Hello from mono")
    }
}