package com.sofia.SmartPark.service;

import com.sofia.SmartPark.model.TbTempParkData;
import com.sofia.SmartPark.param.TempInParkDataParam;

public interface InAndOutParkService {

    /*
    * 保存车辆进入停车场记录
    * @param tempParkData TempInParkDataParam
    * */

    void inPark(TempInParkDataParam tempParkData);

    /*
    * 获取该车辆停车记录根据车牌号
    * @param  license String
    * @return tempParkData TempParkData
    * */
    /*TbTempParkData getTempParkByLicense(String license);
*/

    /*
    * 车辆进出进车场时更新总停车场表的停车位数据
    * @param parkID String
    * */
   /* void upParkSpaceInAllParks(String parkID);
*/
    /*
     *该车辆出停车场时将该记录存进该停车场的历史记录表并删除临时表的数据
     * @param license String
     * */
    void outPark(TempInParkDataParam tempInParkDataParam);

    /*
    * 该车辆出停车场时该记录在临时停车表中删除
    * @param tempInParkDataParam TempInParkDataParam
    * */
/*
    void deleteTempParkDataByLicenseAndParkID(TempInParkDataParam tempInParkDataParam);

*/

}
