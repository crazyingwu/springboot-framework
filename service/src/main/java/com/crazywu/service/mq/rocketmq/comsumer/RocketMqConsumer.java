package com.crazywu.service.mq.rocketmq.comsumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component
//@RocketMQMessageListener(topic = "demo", consumerGroup = "demo")
public class RocketMqConsumer implements RocketMQListener<String> {
    Logger logger = LoggerFactory.getLogger(RocketMqConsumer.class);

    @Override
    public void onMessage(String s) {
//        System.out.println("RocketMqConsumer: " + s);
        logger.info("RocketMqConsumer: {}", s);
    }
}
