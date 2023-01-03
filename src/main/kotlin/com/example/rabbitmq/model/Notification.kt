package com.example.rabbitmq.model

import java.io.Serializable
import java.util.*

data class Notification(
    val notificationId: String? = null,
    val createdAt: Date,
    val seen: Boolean ,
    val message: String? = null
):Serializable
