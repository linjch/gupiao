package com.gupiao.activemq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Value("${spring.activemq.queue-name}")
    private String queueName;

    @JmsListener(destination = "queueName")
    public void receiveQueue(String text){
        System.out.println("收到信息：" + text);
    }
}
