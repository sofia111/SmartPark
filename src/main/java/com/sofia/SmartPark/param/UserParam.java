package com.sofia.SmartPark.param;

/**
*@Author: Sofia
*@Email: feng-sofia@foxmail.com
*@Date: 2019/4/15 9:35
*@Description: 用户的参数返回
*/
public class UserParam {

    private String userName;

    private String password;

    private String phoneNum;

    private String license;

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
