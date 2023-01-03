package com.example.rabbitmq.listener;

import com.example.rabbitmq.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues ="${sr.rabbit.queue.name}" )
    public void handleMessage(Notification notification){
        System.out.println("Listening --> ");
        System.out.println(notification.toString());
        System.out.println("Listener message: " +notification.getMessage() + " boolean : " + notification.getSeen());
    }
}
