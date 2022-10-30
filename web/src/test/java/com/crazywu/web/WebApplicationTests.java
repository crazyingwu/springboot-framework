package com.crazywu.web;

import com.crazywu.dal.mysql.dao.UserDao;
import com.crazywu.service.mq.rocketmq.producer.RocketMqProducerAdapter;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class WebApplicationTests {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private UserDao userDao;

    @Resource
    private RocketMqProducerAdapter rocketMqProducerAdapter;


    @Test
    void contextLoads() throws InterruptedException, MQBrokerException, RemotingException, MQClientException {
//        for (RedisClientInfo redisClientInfo : redisTemplate.getClientList()) {
//            System.out.println(redisClientInfo.getName());
//        }
//        redisTemplate.opsForValue().set("test222", "test");
//        Object o = redisTemplate.opsForValue().get("test");
//        System.out.println(o);
//
//        System.out.println(userDao.selectById(1).getUsername());
//        rocketMQTemplate.convertAndSend("demo", "hello rocketmq");
//        Message message = new Message("demo", "the second message".getBytes());
        rocketMqProducerAdapter.sendDemoMessage("the third message");
        Thread.sleep(4000);
    }

}
