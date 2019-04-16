package com.sofia.SmartPark.mapper;

import com.sofia.SmartPark.model.TbParkHistoryInfo;

public interface ParkHistoryInfoMapper {

    /*
    * 将进出停车场的记录录入该停车场表
    * @param tbParkHistoryInfo TbParkHistoryInfo
    * */
    void insertParkHistoryInfo(TbParkHistoryInfo tbParkHistoryInfo);

}
