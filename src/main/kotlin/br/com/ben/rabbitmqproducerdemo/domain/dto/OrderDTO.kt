package br.com.ben.rabbitmqproducerdemo.domain.dto

data class OrderDTO(
    val orderId: String,
    val descritpion: String,
    val value: Float
)
