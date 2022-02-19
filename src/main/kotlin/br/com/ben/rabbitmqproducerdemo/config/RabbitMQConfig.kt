package br.com.ben.rabbitmqproducerdemo.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {

    @Value("\${queue-name}")
    val QUEUE: String = ""
    @Value("\${exchange-name}")
    val EXCHANGE: String = ""
    @Value("\${routingkey}")
    val ROUTING_KEY: String = ""

    @Bean
    fun queue(): Queue? {
        return Queue(QUEUE)
    }

    @Bean
    fun exchange(): TopicExchange? {
        return TopicExchange(EXCHANGE)
    }

    @Bean
    fun binding(queue: Queue?, exchange: TopicExchange?): Binding? {
        return BindingBuilder
            .bind(queue)
            .to(exchange)
            .with(ROUTING_KEY)
    }

    @Bean
    fun messageConverter(objectMapper: ObjectMapper): MessageConverter {
        return Jackson2JsonMessageConverter(objectMapper)
    }
}