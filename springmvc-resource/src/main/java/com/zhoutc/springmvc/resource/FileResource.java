package com.zhoutc.springmvc.resource;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created by zhoutc on 2016-11-20.
 */
@Controller
@RequestMapping(path = "/v1/springmvc", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class FileResource {

    @RequestMapping(path="/batchByFile", method= RequestMethod.POST, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String batchByFile(
            @RequestParam(value="file",required = true) CommonsMultipartFile file
    ){
        return "";
    }

    @RequestMapping("/importExcelCustom")
    @ResponseBody
    public Object importExcelCustom(@RequestParam("filename") CommonsMultipartFile filename, HttpServletRequest request,
                                    HttpServletResponse response) throws UnsupportedEncodingException {

        return "";
    }
}
