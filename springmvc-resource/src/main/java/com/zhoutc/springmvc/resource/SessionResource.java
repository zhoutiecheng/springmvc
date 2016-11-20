package com.zhoutc.springmvc.resource;

import com.shihui.mutual.log.ApiLogger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhoutc on 2016/6/23.
 */
@Controller
@RequestMapping(path = "/v1/session", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class SessionResource {

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public  @ResponseBody
    String test(@RequestParam(required = true) String username,
                @RequestParam(required = true) String password,
                HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().setAttribute("username", username + ","+password);
        httpServletRequest.getSession().setMaxInactiveInterval(10);
        return "OK";
    }

    @RequestMapping(path = "/ss", method = RequestMethod.GET)
    public  @ResponseBody
    String test1(HttpServletRequest httpServletRequest) {
        System.out.println(httpServletRequest.getSession().getAttribute("username"));
        ApiLogger.info("----------------------");
        return "OK";
    }
}
