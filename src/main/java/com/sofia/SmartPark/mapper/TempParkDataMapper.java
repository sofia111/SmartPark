package com.sofia.SmartPark.mapper;

import com.sofia.SmartPark.model.TbTempParkData;
import com.sofia.SmartPark.param.TempInParkDataParam;
import org.apache.ibatis.annotations.Param;

public interface TempParkDataMapper {

    /*
    *插入进入停车场的车牌号，时间
    * @param license 车牌号
    * */
    void insertTempPark(TbTempParkData tempParkData);

    /*
    * 查找记录根据车牌号
    * @param license String ,parkID String
    * @return TbTempParkData  整条记录
    * */
    TbTempParkData selectTempParkByLicenseAndParkID(@Param("license")String license ,@Param("parkID")String parkID);

    /*
    * 获取已占车位数量
    * @return int
    * */
    int countTempParkData(String parkID);

    /*
    * 删除出库车辆根据车牌号
    * @param String license
    * */
    void deleteTempParkData(TbTempParkData tbTempParkData);


}
