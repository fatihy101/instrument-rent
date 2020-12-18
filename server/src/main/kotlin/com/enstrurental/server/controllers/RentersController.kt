package com.enstrurental.server.controllers

import com.enstrurental.server.entitites.RenterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("renters")
class RentersController(@Autowired private val renterRepository: RenterController) {

}
