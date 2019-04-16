package com.sofia.SmartPark.mapper;

import com.sofia.SmartPark.model.TbUser;

public interface UserMapper {

    /*
    * 添加用户
    * @param user;
    * */
    void insertUser(TbUser user);

    /*
    * 通过用户手机号查询是否有用户存在
    * @return phoneNum
    * */
    String selectUserPhoneNum(String phoneNum);

    /*
    * 获取用户（判断账号密码是否正确）
    *@param user
    * @return TbUser
    *  */
    TbUser selectUserByNameAndPwd(TbUser user);

}
