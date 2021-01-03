package com.enstrurental.server.controllers

import com.enstrurental.server.entitites.Orders
import com.enstrurental.server.entitites.OrdersRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("orders")
@CrossOrigin(origins = ["http://localhost:8080"])

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



    @PutMapping("/{id}/update_delivery_type/")
    fun updateDeliveryType(@PathVariable id: Int, @RequestBody order_updated: Orders) : Mono<ResponseEntity<Orders>>
    {
        return ordersRepository.findById(id)
            .flatMap { order ->
                order.delivery_type = order_updated.delivery_type
                ordersRepository.save(order)
            }
            .map { order -> ResponseEntity.ok(order) }
            .defaultIfEmpty(ResponseEntity(HttpStatus.NOT_FOUND))
    }

    @PutMapping("/{id}/address/")
    fun updateAddress(@PathVariable id: Int, @RequestBody order_updated: Orders) : Mono<ResponseEntity<Orders>>
    {
        return ordersRepository.findById(id)
            .flatMap { order ->
                order.address = order_updated.address
                ordersRepository.save(order)
            }
            .map { order -> ResponseEntity.ok(order) }
            .defaultIfEmpty(ResponseEntity(HttpStatus.NOT_FOUND))

    }

    @PutMapping("/{id}/update_total_rented_days/")
    fun updateTotalRentedDays(@PathVariable id: Int, @RequestBody order_updated: Orders) : Mono<ResponseEntity<Orders>>
    {
        return ordersRepository.findById(id)
            .flatMap { order ->
                order.total_rented_days = order_updated.total_rented_days
                ordersRepository.save(order)
            }
            .map { order -> ResponseEntity.ok(order) }
            .defaultIfEmpty(ResponseEntity(HttpStatus.NOT_FOUND))

    }

    @PutMapping("/{id}/update_tracking_number/")
    fun updateTrackingNumber(@PathVariable id: Int, @RequestBody order_updated: Orders) : Mono<ResponseEntity<Orders>>
    {
        return ordersRepository.findById(id)
            .flatMap { order ->
                order.tracking_number = order_updated.tracking_number
                ordersRepository.save(order)
            }
            .map { order -> ResponseEntity.ok(order) }
            .defaultIfEmpty(ResponseEntity(HttpStatus.NOT_FOUND))
    }

    @PutMapping("/{id}/update_archive/")
    fun updateArchive(@PathVariable id: Int, @RequestBody order_updated: Orders) : Mono<ResponseEntity<Orders>>
    {
        return ordersRepository.findById(id)
            .flatMap { order ->
                order.archive = order_updated.archive
                ordersRepository.save(order)
            }
            .map { order -> ResponseEntity.ok(order) }
            .defaultIfEmpty(ResponseEntity(HttpStatus.NOT_FOUND))
    }

}



