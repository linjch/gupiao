package com.gupiao.ibmmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SendMessage {

    @Value("${project.mq.queueName}")
    private String queueName;

    @Autowired
    JmsOperations jmsOperations;

    @PostConstruct
    public void send(String msg){
        System.out.println("开始发送消息");
        jmsOperations.convertAndSend(queueName, msg);
    }
}
