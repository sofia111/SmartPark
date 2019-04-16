/*
package com.sofia.SmartPark.service;

import com.sofia.SmartPark.controller.UserController;
import com.sofia.SmartPark.mapper.UserMapper;
import com.sofia.SmartPark.model.TbUser;
import com.sofia.SmartPark.param.UserParam;
import com.sofia.SmartPark.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-*.xml"})
public class UserTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void saveUserTest(){

        List<TbUser> userList = new ArrayList<>();
        UserParam userParam = new UserParam();
        TbUser tbUser = new TbUser();
        String password = "1fengds4";
        String username = "2132";
        String phoneNum = "18670373836";
        userParam.setUserName(username);
        userParam.setPhoneNum(phoneNum);
        userParam.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
   */
/*     System.out.println(userParam.getUserName());
        System.out.println(userParam.getPassword());
        BeanUtils.copyProperties(userParam,tbUser);
        System.out.println(tbUser.getPassword());
        System.out.println(tbUser.getUserName());*//*

        userService.saveUser(userParam);
        userMapper.insertUser(tbUser);
        UserController userController  = new UserController();
        userController.register();


        userList.add(tbUser);
        for (TbUser user:userList) {
            System.out.println(user.getUserName()+"--"+user.getPassword());
        }
    }
    @Test
    public void verifyUserTest(){

        TbUser tbUser = new TbUser();
        TbUser user = new TbUser();
        UserParam userParam = new UserParam();
        String password = "1234";
        String username = "2132";

        userParam.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        userParam.setUserName(username);

        BeanUtils.copyProperties(userParam,tbUser);
        System.out.println(tbUser.getUserName());
        System.out.println(tbUser.getPassword());
        user = userMapper.selectUserByNameAndPwd(tbUser);

        System.out.println(user.getUserName()+user.getPassword());
    }
}
*/
