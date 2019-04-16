package com.sofia.SmartPark.model;

/**
*@Author: Sofia
*@Email: feng-sofia@foxmail.com
*@Date: 2019/4/15 9:33
*@Description: 总停车场表的实体类
*/
public class TbAllParks {

    private Integer info;
    private String parkID;
    private Double lng;
    private Double lat;
    private Integer parkingSpace;
    private Integer totalParkingSpace;
    private String parkName;
    private String address;
    private String parkImg;
    private Float cost;

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

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

    public Double getLongitude() {
        return lng;
    }

    public void setLongitude(Double lng) {
        this.lng = lng;
    }

    public Double getLatitude() {
        return lat;
    }

    public void setLatitude(Double latitude) {
        this.lat = lat;
    }

    public Integer getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(Integer parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public Integer getTotalParkingSpace() {
        return totalParkingSpace;
    }

    public void setTotalParkingSpace(Integer totalParkingSpace) {
        this.totalParkingSpace = totalParkingSpace;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParkImg() {
        return parkImg;
    }

    public void setParkImg(String parkImg) {
        this.parkImg = parkImg;
    }
}
