package com.crazywu.common.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RocketMqConstant {

    @Value("${rocketmq.name-server}")
    public static final String NAME_SERVER_ADDR = "192.168.199.245:9876";

    @Value("${rocketmq.consumer.topic}")
    public static final String TOPIC = "demo";
    @Value("${rocketmq.producer.group}")
    public static final String PRODUCER_GROUP = "demo";
    @Value("${rocketmq.consumer.group}")
    public static final String CONSUMER_GROUP = "demo";
}
