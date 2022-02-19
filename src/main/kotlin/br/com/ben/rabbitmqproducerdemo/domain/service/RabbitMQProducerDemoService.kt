package br.com.ben.rabbitmqproducerdemo.domain.service

import br.com.ben.rabbitmqproducerdemo.config.RabbitMQConfig
import br.com.ben.rabbitmqproducerdemo.domain.dto.OrderDTO
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service

@Service
class RabbitMQProducerDemoService(
    private val rabbitTemplate: RabbitTemplate,
    private val config: RabbitMQConfig,
) {

    private val log = LoggerFactory.getLogger(javaClass)

    fun sendMessage(message: OrderDTO) {
        log.info("Enviando messagem $message")
        rabbitTemplate.convertAndSend(config.EXCHANGE, config.ROUTING_KEY, message)
    }
}