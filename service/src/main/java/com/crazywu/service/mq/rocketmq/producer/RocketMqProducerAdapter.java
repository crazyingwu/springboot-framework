package com.crazywu.service.mq.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RocketMqProducerAdapter {

    private static final String TOPIC = "demo";

    @Resource
    private DefaultMQProducer myMqProducer;


    public void send(String topic, String message) {
        try {
            myMqProducer.send(new Message(topic, message.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendDemoMessage(String message) {
        send(TOPIC, message);
    }


}
