package com.crazywu.web;

import com.crazywu.dal.mysql.dao.UserDao;
import com.crazywu.extern.api.EchoService;
import com.crazywu.service.apollo.config.UserConfig;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class WebApplicationTests {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private UserDao userDao;

//    @Resource
//    private RocketMqProducerAdapter rocketMqProducerAdapter;

    @Resource
    private UserConfig userConfig;

    @DubboReference(version = "1.0.0")
    private EchoService echoService;

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
//        rocketMqProducerAdapter.sendDemoMessage("the third message");
//        Thread.sleep(4000);

        System.out.println(echoService.add(1,3));
    }

}
