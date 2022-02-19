package br.com.ben.rabbitmqproducerdemo.controller

import br.com.ben.rabbitmqproducerdemo.domain.dto.OrderDTO
import br.com.ben.rabbitmqproducerdemo.domain.service.RabbitMQProducerDemoService
import org.springframework.http.HttpEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("rabbitmq")
class RabbitMQProducerDemoController(private val service: RabbitMQProducerDemoService) {

    @PostMapping("/enviar")
    fun sendMessage(
        @RequestBody message: OrderDTO
    ): HttpEntity<Any?> {
        service.sendMessage(message)
        return ResponseEntity.ok().build()
    }
}