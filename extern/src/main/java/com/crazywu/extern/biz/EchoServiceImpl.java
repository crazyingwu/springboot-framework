package com.crazywu.extern.biz;

import com.crazywu.extern.api.EchoService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0.0")
public class EchoServiceImpl implements EchoService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
