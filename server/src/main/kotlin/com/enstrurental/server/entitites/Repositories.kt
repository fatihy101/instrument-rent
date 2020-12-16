package com.enstrurental.server.entitites

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: ReactiveMongoRepository<Users, String>

@Repository
interface RenterRepository: ReactiveMongoRepository<Renters, String>

@Repository
interface OrderRepository: ReactiveMongoRepository<Orders, Int>

@Repository
interface InstrumentRepository: ReactiveMongoRepository<Instruments, String>{
    // fun findByCategory()

}
