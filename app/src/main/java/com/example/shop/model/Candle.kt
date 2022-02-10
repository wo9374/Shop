package com.example.shop.model

data class Candle(
    val createdAt: Long,
    val open: Float,
    val close: Float,
    val shadowHigh: Float,
    val shadowLow: Float
)