package com.sofia.SmartPark.param;

import java.util.Date;

/**
*@Author: Sofia
*@Email: feng-sofia@foxmail.com
*@Date: 2019/4/15 9:34
*@Description: 临时停车场返回的参数
*/
public class TempInParkDataParam {

    private String license;

    private String parkID;

    private Date inTime;

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

    private Date outTime;

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getParkID() {
        return parkID;
    }

    public void setParkID(String parkID) {
        this.parkID = parkID;
    }


}
