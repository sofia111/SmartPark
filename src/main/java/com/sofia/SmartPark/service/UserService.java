package com.sofia.SmartPark.service;

import com.sofia.SmartPark.param.UserParam;


public interface UserService {

    /*
    * 保存用户
    * @param user UserParam
    * */

    void saveUser(UserParam user);

    /*
    * 检测用户信息
    * @param user Userparam
    * @param request HttpServletRequest
    * */

    boolean verifyUser(UserParam user);

}
