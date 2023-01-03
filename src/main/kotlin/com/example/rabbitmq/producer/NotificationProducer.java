package com.example.rabbitmq.producer;

import com.example.rabbitmq.model.Notification;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class NotificationProducer {
    private final  AmqpTemplate rabbitTemplate;
    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;
    @Value("${sr.rabbit.routing.name}")
    private String routingName;


    public NotificationProducer(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostConstruct
    public void init(){
        Notification notification = new Notification
                (
                UUID.randomUUID().toString(),
                new Date(),
                false,
                "message"
                );
        sendToQueue(notification);
    }

    public  void sendToQueue(Notification notification){
        System.out.println("Notification: send id "+ notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName,routingName,notification);
    }
}
