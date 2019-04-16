package com.sofia.SmartPark.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.sofia.SmartPark.beans.CaculateDistance;
import com.sofia.SmartPark.mapper.AllParksMapper;
import com.sofia.SmartPark.model.TbAllParks;
import com.sofia.SmartPark.param.SearchNearbyParksParam;
import com.sofia.SmartPark.service.SearchNearbyParksService;
import com.sofia.SmartPark.vo.SearchNearbyParksVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*@Author: Sofia
*@Email: feng-sofia@foxmail.com
*@Date: 2019/4/15 9:35
*@Description: 搜索停车场的service类
*/
@Service
public class SearchNearbyParksServiceImpl implements SearchNearbyParksService {

    @Autowired
    AllParksMapper allParksMapper;

    public SearchNearbyParksServiceImpl(AllParksMapper allParksMapper) {

        this.allParksMapper = allParksMapper;
    }

    @Override
    public List<SearchNearbyParksVo> searchNearbyParks(Double longitude, Double latitude) {

        SearchNearbyParksParam searchNearbyParksParam = new SearchNearbyParksParam();
        List<TbAllParks> tbAllParks;
        List<SearchNearbyParksVo> searchNearbyParksVo = Lists.newLinkedList();
        CaculateDistance caculateDistance = new CaculateDistance();
        double longitude2;
        double latitude2;
        searchNearbyParksParam.setLongitude(longitude);
        searchNearbyParksParam.setLatitude(latitude);

        tbAllParks = allParksMapper.getAllparks();
        for (TbAllParks allparks: tbAllParks) {
            SearchNearbyParksVo searchNearbyParksVo1 = new SearchNearbyParksVo();
            longitude2 = allparks.getLongitude();
            latitude2 = allparks.getLatitude();
            Double distance = caculateDistance.algorithm(longitude,latitude,longitude2,latitude2);
         //   System.out.println(distance);
            if (distance<3000){

                System.out.println(JSONObject.toJSONString(allparks));

                BeanUtils.copyProperties(allparks,searchNearbyParksVo1);
             /*   System.out.println(JSONObject.toJSONString(searchNearbyParksVo1));*/
                searchNearbyParksVo.add(searchNearbyParksVo1);System.out.println(JSONObject.toJSONString(searchNearbyParksVo));
            }

        }
        return searchNearbyParksVo;
    }
}
