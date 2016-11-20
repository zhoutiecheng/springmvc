package com.zhoutc.springmvc.service;

import com.zhoutc.springmvc.api.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by zhoutc on 2016/6/15.
 */
@Service
public class UserServiceImpl implements UserService{
    @Override
    public void test() {
        System.out.println("UserServiceImpl");
    }
}
