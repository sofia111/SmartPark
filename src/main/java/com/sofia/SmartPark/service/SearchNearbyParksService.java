package com.sofia.SmartPark.service;

import com.sofia.SmartPark.vo.SearchNearbyParksVo;

import java.util.LinkedHashSet;
import java.util.List;

public interface SearchNearbyParksService {

    /*
    * 通过搜索的经纬度获取附近的停车场
    * @param longitude String latitude String
    * @return SearchNearbyParksVo
    * */
   List<SearchNearbyParksVo> searchNearbyParks(Double longitude, Double latitude);

}
