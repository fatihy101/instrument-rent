package com.enstrurental.server.entitites

import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, String>

interface RenterRepository: MongoRepository<Renter, String>

interface OrderRepository: MongoRepository<Order, Int>

interface InstrumentRepository: MongoRepository<Instrument, String>{
    // fun findByCategory()
}
