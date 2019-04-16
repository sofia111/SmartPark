package com.sofia.SmartPark.vo;

public class SearchNearbyParksVo {

    private String parkID;
    private Double latitude;
    private Double longitude;
    private Integer parkingSpace;
    private String parkName;
    private String address;
    private String parkImg;
    private Float cost;

    public float getCost() {
        return cost;
    }


    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getParkID() {
        return parkID;
    }

    public void setParkID(String parkID) {
        this.parkID = parkID;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(Integer parkingSpace) {
        this.parkingSpace = parkingSpace;
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
