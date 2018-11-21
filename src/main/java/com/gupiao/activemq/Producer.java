package com.gupiao.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    private static int count = 0;

    public void send(Destination destination, final String msg){
        jmsMessagingTemplate.convertAndSend(destination, msg);
    }
}
