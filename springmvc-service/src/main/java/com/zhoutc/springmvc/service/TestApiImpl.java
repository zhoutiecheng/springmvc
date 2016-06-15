package com.zhoutc.springmvc.service;

import com.zhoutc.springmvc.api.TestApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by zhoutc on 2016/4/27.
 */
@Service("testapi1")
public class TestApiImpl implements TestApi {

    @Value("${test_say_world}")
    private String world;
    /**
     * 打印Hello World
     * @return
     */
    @Override
    public void sayHello() {
        System.out.println("hello");
        return;
    }
}
