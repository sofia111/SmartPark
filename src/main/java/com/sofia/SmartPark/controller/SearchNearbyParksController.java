package com.sofia.SmartPark.controller;

import com.sofia.SmartPark.beans.ResultData;
import com.sofia.SmartPark.service.SearchNearbyParksService;
import com.sofia.SmartPark.vo.SearchNearbyParksVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
*@Author: Sofia
*@Email: feng-sofia@foxmail.com
*@Date: 2019/4/15 9:31
*@Description: 搜索附近的停车场的控制块
*/
@Controller
@RequestMapping(value = "/Park")
public class SearchNearbyParksController {


    private final SearchNearbyParksService searchNearbyParksService;

    @Autowired
    public SearchNearbyParksController(SearchNearbyParksService searchNearbyParksService) {
        this.searchNearbyParksService = searchNearbyParksService;
    }

    @RequestMapping(value = "/searchNearbyParks")
    @ResponseBody
    public ResultData getNearbyParks( Double longitude,Double latitude){

     /*   System.out.println(longitude+"   "+latitude);
        System.out.println("32456");*/
        List<SearchNearbyParksVo> searchNearbyParksVo ;
        searchNearbyParksVo = searchNearbyParksService.searchNearbyParks(longitude,latitude);
        if (searchNearbyParksVo == null){
            return ResultData.success("周围十公里无停车场");
        }else{
            return ResultData.success(searchNearbyParksVo);
        }
    }
}
