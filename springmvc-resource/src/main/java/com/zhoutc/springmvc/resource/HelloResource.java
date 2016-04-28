package com.zhoutc.springmvc.resource;


import com.zhoutc.springmvc.api.TestApi;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by zhoutc on 2016/4/27.
 */
@Controller
@RequestMapping(path = "/v1/springmvc", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class HelloResource {
    @Resource
    public TestApi testApi;

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public  @ResponseBody String hello(@RequestParam(required = false) Integer type) {
         testApi.sayHello();

        return "OK";
    }


}
