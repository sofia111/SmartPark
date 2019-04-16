package com.sofia.SmartPark.service.impl;

import com.sofia.SmartPark.common.CookieSessionManage;
import com.sofia.SmartPark.exception.UserException;
import com.sofia.SmartPark.mapper.UserMapper;
import com.sofia.SmartPark.model.TbUser;
import com.sofia.SmartPark.param.UserParam;
import com.sofia.SmartPark.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;

/**
*@Author: Sofia
*@Email: feng-sofia@foxmail.com
*@Date: 2019/4/15 9:36
*@Description: 用户的 service类
*/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void saveUser(UserParam user) {

        /**
        *@Description: 保存用户信息到数据库userInfo表
        *@params: [user]
        *@return: void
        **/
        TbUser tbUser = new TbUser();
     //   System.out.println(userMapper.selectUserPhoneNum());
        if (userMapper.selectUserPhoneNum(tbUser.getPhoneNum()) != null){
                throw new UserException("该手机号已经被注册");
        }
        BeanUtils.copyProperties(user,tbUser);
        userMapper.insertUser(tbUser);
    }

    @Override
    public boolean verifyUser(UserParam user) {

        /**
        *@Description: 验证用户登录是否正确
        *@params: [user]
        *@return: boolean
        **/
      //  user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
       // System.out.println(user.getPassword());
        TbUser tbUser = new TbUser();
        System.out.println(user.getUserName());
        BeanUtils.copyProperties(user,tbUser);
       // System.out.println(tbUser.getPassword());
        tbUser = userMapper.selectUserByNameAndPwd(tbUser);

        if (tbUser == null){

           return false;
        }
       // tbUser.setPassword(null);
     /*   CookieSessionManage.setSession(request,tbUser);*/

        return true;
    }
}
