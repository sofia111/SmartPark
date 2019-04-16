/*

package com.sofia.SmartPark.service;

import com.alibaba.fastjson.JSONObject;
import com.sofia.SmartPark.mapper.AllParksMapper;
import com.sofia.SmartPark.mapper.ParkHistoryInfoMapper;
import com.sofia.SmartPark.mapper.TempParkDataMapper;
import com.sofia.SmartPark.model.TbAllParks;
import com.sofia.SmartPark.model.TbParkHistoryInfo;
import com.sofia.SmartPark.model.TbTempParkData;
import com.sofia.SmartPark.param.SearchNearbyParksParam;
import com.sofia.SmartPark.param.TempInParkDataParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class InAndOutParkTest {

    @Autowired
    AllParksMapper allParksMapper;

    @Autowired
    TempParkDataMapper tempParkDataMapper;

    @Autowired
    InAndOutParkService inAndOutParkService;

    @Autowired
    ParkHistoryInfoMapper parkHistoryInfoMapper;

    @Test
    public void inParkTest(){

        TempInParkDataParam tempInParkDataParam = new TempInParkDataParam();
        tempInParkDataParam.setLicense("ttt");
        tempInParkDataParam.setParkID("1");
        TbTempParkData tbTempParkData = new TbTempParkData();
        tbTempParkData.setInTime(new Date());
        BeanUtils.copyProperties(tempInParkDataParam,tbTempParkData);
        tempParkDataMapper.insertTempPark(tbTempParkData);
        int parkingSpace =  tempParkDataMapper.countTempParkData(tbTempParkData.getParkID());
        System.out.println(parkingSpace);

        //查询停车场的功能
        SearchNearbyParksParam searchNearbyParksParam = new SearchNearbyParksParam();
        searchNearbyParksParam.setLongitude(234.545);
        searchNearbyParksParam.setLatitude(343.234);

        TbAllParks tbAllParks;
        tbAllParks = allParksMapper.getAllparks(searchNearbyParksParam);
        System.out.println(JSONObject.toJSONString(tbAllParks));

     int t=   tempParkDataMapper.countTempParkData(tbTempParkData.getParkID());
        System.out.println(t);

        //更新停车位
        allParksMapper.updateParkSpace(t,"1");
        inAndOutParkService.inPark(tempInParkDataParam);

    }

    @Test
    public void outPark(){

    TempInParkDataParam tempInParkDataParam = new TempInParkDataParam();
          TbParkHistoryInfo tbParkHistoryInfo = new TbParkHistoryInfo();
        TbTempParkData tbTempParkData ;

          tempInParkDataParam.setLicense("feng");
        tempInParkDataParam.setParkID("1");
        tbTempParkData = tempParkDataMapper.selectTempParkByLicenseAndParkID(tempInParkDataParam.getLicense(),tempInParkDataParam.getParkID());
        tbParkHistoryInfo.setOutTime(new Date());
        tbParkHistoryInfo.setNeedPay((float) 35.54);
        tbParkHistoryInfo.setIspayed((byte) 1);
        BeanUtils.copyProperties(tbTempParkData,tbParkHistoryInfo);
        parkHistoryInfoMapper.insertParkHistoryInfo(tbParkHistoryInfo);
       tbTempParkData = tempParkDataMapper.selectTempParkByLicenseAndParkID(tempInParkDataParam.getLicense(),tempInParkDataParam.getParkID());

       tempParkDataMapper.deleteTempParkData(tbTempParkData);
        inAndOutParkService.outPark(tempInParkDataParam);

    }



}*/
