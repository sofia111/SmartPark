package com.sofia.SmartPark.controller;

/*
* 用户controller
* */

import com.sofia.SmartPark.exception.UserException;
import com.sofia.SmartPark.service.SendMessage;
import org.apache.commons.lang3.StringUtils;
import com.sofia.SmartPark.beans.ResultData;
import com.sofia.SmartPark.param.UserParam;
import com.sofia.SmartPark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
*@Author: Sofia
*@Email: feng-sofia@foxmail.com
*@Date: 2019/4/15 9:32
*@Description: 用户注册登录的控制块
*/
@Controller
@RequestMapping(value = "/user")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/register")
    @ResponseBody
    public ResultData register(UserParam userParam){
      /*  UserParam userParam = new UserParam();
        userParam.setUserName("3r4");
        userParam.setPassword("egbr");
        userParam.setPhoneNum("13212312312");
        System.out.println(JSONObject.toJSONString(userParam));*/
        String Msg="注册成功";
        System.out.println(userParam.getPassword());
        System.out.println(userParam.getUserName());
        System.out.println(userParam.getPhoneNum());
        if(StringUtils.isBlank(userParam.getUserName())){
            Msg="账户名不能为空";
        }else if(StringUtils.isBlank(userParam.getPassword())){
            Msg="密码不能为空";
        }if (StringUtils.isBlank(userParam.getPhoneNum())){
            Msg="手机号不能为空";

        }else{
            try {
                userService.saveUser(userParam);
            }catch (UserException e){
                return  ResultData.fail(e.getMessage());
            }
        }
        return ResultData.success(Msg);
    }

    @RequestMapping(value = "/sendCode")
    @ResponseBody
    public ResultData sendCode(String phoneNum){
        String Msg = null;
        if (StringUtils.isBlank(phoneNum)){
            Msg  = "手机号为空";
        }
        SendMessage sendMessage = new SendMessage();
        Msg = sendMessage.sendMessage(phoneNum);
        return  ResultData.success(Msg);
    }

    @RequestMapping(value = "/login")
    @ResponseBody/*返回数据注解*//**/
    public ResultData login(UserParam userParam, HttpServletRequest request ){

      /*  UserParam userParam = new UserParam();
        userParam.setUserName("3r4");
        userParam.setPassword("egbr");
        System.out.println(JSONObject.toJSONString(userParam));*/
        String Msg = "登录成功";
        if (StringUtils.isBlank(userParam.getUserName())) {
            Msg = "账户名不能为空";
        } else if (StringUtils.isBlank(userParam.getPassword())) {
            Msg = "密码不能为空";
        } else {
            try {
                boolean flag = userService.verifyUser(userParam);
                System.out.println(flag);
                return ResultData.success(flag);
            } catch (UserException e) {
                return ResultData.fail(e.getMessage());
            }
        }
        return ResultData.success(Msg);
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        return "redirect:";
    }
}

