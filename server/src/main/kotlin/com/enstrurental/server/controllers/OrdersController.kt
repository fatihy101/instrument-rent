package com.enstrurental.server.controllers

import com.enstrurental.server.entitites.Orders
import com.enstrurental.server.entitites.OrdersRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("orders")
class OrdersController(val ordersRepository: OrdersRepository) {
    /* TODO operations:
    *  Create order.
    *  Get where renter is current.renter (by renter id)
    *  Get where buyer is current.buyer (by user id)
    *  add initial photos.
    *  add last photos.
    * */

    @GetMapping("/")
    fun getAllOrders(): Flux<Orders> = ordersRepository.findAll()


    @GetMapping("/{orderId}")
    fun getOrderById(@PathVariable orderId : Int): Mono<ResponseEntity<Orders>> {
        return ordersRepository.findById(orderId)
            .map { order -> ResponseEntity.ok(order) }
            .defaultIfEmpty(ResponseEntity.notFound().build())
    }

    @PostMapping("/create")
    fun createOrder(@RequestBody orders: Orders): Mono<ResponseEntity<Orders>> {
        return ordersRepository.save(orders)
            .map { createdOrder -> ResponseEntity.ok(createdOrder) }
            .defaultIfEmpty(ResponseEntity.notFound().build())
    }

}



