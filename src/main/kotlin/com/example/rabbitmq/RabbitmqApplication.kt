package com.example.rabbitmq

import com.example.rabbitmq.model.Notification
import com.example.rabbitmq.producer.NotificationProducer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*

@SpringBootApplication
class RabbitmqApplication

fun main(args: Array<String>) {

	runApplication<RabbitmqApplication>(*args)

}
