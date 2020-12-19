package com.enstrurental.server.entitites

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository: ReactiveMongoRepository<Users, String>

@Repository
interface RentersRepository: ReactiveMongoRepository<Renters, String>

@Repository
interface OrdersRepository: ReactiveMongoRepository<Orders, Int>

@Repository
interface InstrumentsRepository: ReactiveMongoRepository<Instruments, String>

@Repository
interface AddressesRepository: ReactiveMongoRepository<Addresses, Int>