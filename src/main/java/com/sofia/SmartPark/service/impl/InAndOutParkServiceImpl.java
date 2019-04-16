package com.sofia.SmartPark.service.impl;

import com.sofia.SmartPark.mapper.AllParksMapper;
import com.sofia.SmartPark.mapper.ParkHistoryInfoMapper;
import com.sofia.SmartPark.mapper.TempParkDataMapper;
import com.sofia.SmartPark.model.TbParkHistoryInfo;
import com.sofia.SmartPark.model.TbTempParkData;
import com.sofia.SmartPark.param.TempInParkDataParam;
import com.sofia.SmartPark.service.InAndOutParkService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InAndOutParkServiceImpl implements InAndOutParkService {

    @Autowired
    private TempParkDataMapper tempParkDataMapper;

    @Autowired
    private ParkHistoryInfoMapper parkHistoryInfoMapper;

    @Autowired
    private AllParksMapper allParksMapper;

    public InAndOutParkServiceImpl(TempParkDataMapper tempParkDataMapper,ParkHistoryInfoMapper parkHistoryInfoMapper) {
        this.tempParkDataMapper = tempParkDataMapper;
        this.parkHistoryInfoMapper = parkHistoryInfoMapper;
    }


    @Override
    public void inPark(TempInParkDataParam tempInParkData) {

        TbTempParkData tbTempParkData = new TbTempParkData();
        tbTempParkData.setInTime(new Date());

        BeanUtils.copyProperties(tempInParkData,tbTempParkData);
        tempParkDataMapper.insertTempPark(tbTempParkData);

        //更新总停车场表的停车位数据
        Integer parkingSpace = tempParkDataMapper.countTempParkData(tempInParkData.getParkID());
        allParksMapper.updateParkSpace(parkingSpace,tempInParkData.getParkID());
    }

/*
    @Override
    public TbTempParkData getTempParkByLicense(String license) {

        TbTempParkData tbTempParkData;
        tbTempParkData = tempParkDataMapper.selectTempParkByLicense(license);
        return tbTempParkData;
    }
*/

    @Override
    public void outPark(TempInParkDataParam tempInParkDataParam) {

        String license = tempInParkDataParam.getLicense();
        String parkID = tempInParkDataParam.getParkID();
        TbTempParkData tbTempParkData = new TbTempParkData();
        TbParkHistoryInfo tbParkHistoryInfo = new TbParkHistoryInfo();

//        获取一条临时停车场的记录
        tbTempParkData = tempParkDataMapper.selectTempParkByLicenseAndParkID(license,parkID);
        tbParkHistoryInfo.setOutTime(new Date());
        BeanUtils.copyProperties(tbTempParkData,tbParkHistoryInfo);

       /*
       *计算停车费用
       * tbParkHistoryInfo.getInTime(),tbParkHistoryInfo.getOutTime()
       * needPay
       * tbParkHistoryInfo.setNeedPay();
       * */

       //测试用的
        tbParkHistoryInfo.setNeedPay((float) 3435);
        tbParkHistoryInfo.setIspayed((byte) 0);
       parkHistoryInfoMapper.insertParkHistoryInfo(tbParkHistoryInfo);
       tempParkDataMapper.deleteTempParkData(tbTempParkData);

        //更新总停车场表的停车位数据
        int parkingSpace = tempParkDataMapper.countTempParkData(parkID);
        allParksMapper.updateParkSpace(parkingSpace,parkID);

    }
}
