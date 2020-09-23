package com.mading.controller;

import com.alibaba.fastjson.JSONObject;
import com.mading.service.ConsumerService;
import com.mading.service.impl.ConsumerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RestController
public class ConsumerController {
    @Autowired
    private ConsumerServiceImpl consumerService;

    @Configuration
    public class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/avatorImages/**").addResourceLocations("file:C:\\Users\\D\\Desktop\\music-website\\music-server\\avatorImages\\");
        }
    }

    //用户登录，登录成功获取用户信息
    @ResponseBody
    @RequestMapping(value = "user/login/status" , method = RequestMethod.POST)
    public Object loginStatus(HttpServletRequest req , HttpSession session){
        JSONObject jsonObject = new JSONObject();
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        boolean result = consumerService.verifypassword(username , password);
        if(result){
            jsonObject.put("code" , 1);
            jsonObject.put("msg" , "登陆成功");
            jsonObject.put("userMsg", consumerService.loginStatus(username));
            session.setAttribute("username", username);
            return jsonObject;
        }else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "用户名或密码错误");
            return jsonObject;
        }
    }

    //获取指定id用户信息
    @RequestMapping(value = "/user/detail" , method = RequestMethod.GET)
    public Object userOfId(HttpServletRequest req){
        String id = req.getParameter("id");
        return consumerService.userOfId(Integer.parseInt(id));
    }
}
