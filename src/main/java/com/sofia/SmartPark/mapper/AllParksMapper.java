package com.sofia.SmartPark.mapper;

import com.sofia.SmartPark.model.TbAllParks;
import com.sofia.SmartPark.param.SearchNearbyParksParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AllParksMapper {

    /*
    * 更新总停车场的车位数据
    * */
    void updateParkSpace(@Param("parkingSpace") Integer parkingSpace, @Param("parkID") String parkID);
    /*
    * 获取周围停车场数据
    * @param longitude String
    * @param latitude String
    * @return searchNearbyParksVo SearchNearbyParksVo
    * *//*SearchNearbyParksParam searchNearbyParksParam*/
    List<TbAllParks> getAllparks();


}
