/*
package com.sofia.SmartPark.controller;

import com.alibaba.fastjson.JSONObject;
import com.sofia.SmartPark.beans.ResultData;
import com.sofia.SmartPark.param.TempInParkDataParam;
import com.sofia.SmartPark.service.InAndOutParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/Park")
public class InAndOutParkController {

    private final InAndOutParkService inAndOutParkService;

    @Autowired
    public InAndOutParkController(InAndOutParkService inAndOutParkService){
        this.inAndOutParkService = inAndOutParkService;
    }

    @ResponseBody
    @RequestMapping(value = "/inPark")
    public ResultData inPark(TempInParkDataParam tempInParkDataParam){

    //   TempInParkDataParam tempInParkDataParam = new TempInParkDataParam();
      tempInParkDataParam.setLicense("345");
      */
/*  tempInParkDataParam.setParkID("1");*//*

        System.out.println(JSONObject.toJSONString(tempInParkDataParam));
        inAndOutParkService.inPark(tempInParkDataParam);
       return ResultData.success("进入成功");

    }

    @ResponseBody
    @RequestMapping(value = "/outPark")
    public ResultData outPark(TempInParkDataParam tempInParkDataParam) {
       */
/* TempInParkDataParam tempInParkDataParam = new TempInParkDataParam();
        tempInParkDataParam.setLicense("345");
        tempInParkDataParam.setParkID("1");*//*

        System.out.println(JSONObject.toJSONString(tempInParkDataParam));
        inAndOutParkService.outPark(tempInParkDataParam);
        return ResultData.success("出库成功");

    }
}
*/
