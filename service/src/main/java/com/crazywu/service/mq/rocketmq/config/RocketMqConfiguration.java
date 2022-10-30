package com.crazywu.service.mq.rocketmq.config;

import com.crazywu.common.constant.RocketMqConstant;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class RocketMqConfiguration {

    @Resource
    private MessageListenerConcurrently HelloMqConsumer;

    @Bean
    public DefaultMQProducer myMqProducer() throws MQClientException {

        DefaultMQProducer producer = new DefaultMQProducer(RocketMqConstant.PRODUCER_GROUP);
        producer.setNamesrvAddr(RocketMqConstant.NAME_SERVER_ADDR);
        producer.setSendMsgTimeout(15000);
        producer.setVipChannelEnabled(false);
        producer.start();
        return producer;
    }

    @Bean
    public DefaultMQPushConsumer myMqConsumer() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(RocketMqConstant.CONSUMER_GROUP);
        consumer.setNamesrvAddr(RocketMqConstant.NAME_SERVER_ADDR);
        consumer.setVipChannelEnabled(false);
        consumer.subscribe(RocketMqConstant.TOPIC, "*");
        consumer.setMessageListener(HelloMqConsumer);
        consumer.start();
        return consumer;
    }
}
