package com.zhoutc.springmvc.resource;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhoutc on 2016/6/15.
 */
@Controller
@RequestMapping(path = "/v1/springmvc/test", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class TesstResource {


    @RequestMapping(value="/{merchant}")
    @ResponseBody
    public String notice(HttpServletRequest httpServletRequest,
                         @PathVariable String merchant,
                         @RequestBody(required = false) String body){

        return "hello " + httpServletRequest.getMethod();
    }
}
