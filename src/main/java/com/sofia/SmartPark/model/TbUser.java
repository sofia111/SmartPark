package com.sofia.SmartPark.model;

/**
*@Author: Sofia
*@Email: feng-sofia@foxmail.com
*@Date: 2019/4/15 9:34
*@Description: 用户的实体类
*/
public class TbUser {

    private Integer info;

    private String userName;

    private String password;

    private String phoneNum;

    private String license;

    private String driveLicenseImg;

    private String engineID;

    private float money;


    public Integer getInfo() {
        return info;
    }

    public void setInfo(Integer info) {
        this.info = info;
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

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getDriveLicenseImg() {
        return driveLicenseImg;
    }

    public void setDriveLicenseImg(String driveLicenseImg) {
        this.driveLicenseImg = driveLicenseImg;
    }

    public String getEngineID() {
        return engineID;
    }

    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }
}
