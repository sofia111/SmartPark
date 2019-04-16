package com.sofia.SmartPark.model;

import java.util.Date;
/**
*@Author: Sofia
*@Email: feng-sofia@foxmail.com
*@Date: 2019/4/15 9:33
*@Description: 停车场历史记录的实体类
*/
public class TbParkHistoryInfo {

    private Integer info;
    private String parkID;
    private Date inTime;
    private Date outTime;
    private String license;
    private Float needPay;
    private Byte ispayed;

    public Integer getInfo() {
        return info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public String getParkID() {
        return parkID;
    }

    public void setParkID(String parkID) {
        this.parkID = parkID;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Float getNeedPay() {
        return needPay;
    }

    public void setNeedPay(Float needPay) {
        this.needPay = needPay;
    }

    public Byte getIspayed() {
        return ispayed;
    }

    public void setIspayed(Byte ispayed) {
        this.ispayed = ispayed;
    }

}
