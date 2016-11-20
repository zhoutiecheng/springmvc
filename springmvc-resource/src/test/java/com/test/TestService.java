package com.test;

import com.zhoutc.springmvc.api.TestApi;
import com.zhoutc.springmvc.api.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * Created by zhoutc on 2016/6/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration({"/spring.xml"}) //加载配置文件
public class TestService {
    @Resource(name="testapi1")
    private TestApi testApi;
    @Resource
    private UserService userService;

    @Test   //标明是测试方法
    public void insert() {
        userService.test();
    }


}
