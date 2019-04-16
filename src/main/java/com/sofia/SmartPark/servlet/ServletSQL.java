package com.sofia.SmartPark.servlet;

import com.alibaba.fastjson.JSONArray;

import java.sql.*;

/**
*@Author: Sofia
*@Email: feng-sofia@foxmail.com
*@Date: 2019/4/15 9:39
*@Description: 从摄像头端接收车牌号后对数据库进行的一系列操作
*/
public class ServletSQL {

    DBConnection con = new DBConnection();

    public PreparedStatement excuteSQL(String sql, int count, String[] param){

        /**
         *@Description: 封装执行的增删改查数据库函数
         *@params: [sql, count, param]
         *@return: java.sql.PreparedStatement
         **/
        PreparedStatement ps = null;
        try {
            ps = con.getCon().prepareStatement(sql);
            for (int i = 0; i < count; i++) {
                System.out.println(param[i]);
                ps.setString(i + 1, param[i]);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

     return ps;
    }


    public boolean hasLicenseInPark(String license, String parkID){
        /**
        *@Description: 根据车牌号查询临时停车场表中是否有该车牌号，以此判断是进停车场还是出
        *@params: [license, parkID]
        *@return: boolean
        **/
         ResultSet rs = null;
         String[] param = new String[2];
         String sql = "select * from tempParkData where license = ? and parkID = ?";

         param[0] = license;
         param[1] = parkID;
         PreparedStatement ps  = excuteSQL(sql,2,param);

         try {
             rs =  ps.executeQuery();
             while (rs.next()){
                 return true;
             }
         }catch (SQLException e){
             e.printStackTrace();
         }
         return false;
    }


    public boolean updateParkingSpace(String parkID){

        /**
        *@Description: 更新总停车场的每个停车场的车位数用量
         *      1.通过license查询tempParkData表中某个停车parkID中的记录条数，以此说明某个停车场的车位用量
         *      2. 更新allParks中parkID的车位占用量
        *@params: [parkID]
        *@return: boolean
        **/

        try {
            //通过临时停车场表的parkID查询出所占的停车位；
            String[] param1 = new String[1];
            String  sql = "select license from tempParkData where parkID = ?";
            param1[0] = parkID;
            PreparedStatement ps = excuteSQL(sql,1,param1);
            ResultSet rs =  ps.executeQuery();
            int licenseCount = 0;
            if(rs.next()){
                licenseCount = rs.getRow();
            }


            //将总停车场的表的车位数更新
            sql = "update allParks set parkingSpace = ? where parkID = ?";
            String[] param2 = new String[2];
            param2[0] = String.valueOf(licenseCount);
            param2[1] = parkID;
            ps = excuteSQL(sql,2,param2);
            if (ps.executeUpdate() != 0){
                return true;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;

    }

     public String inPark(String license, String parkID,String inTime){

         /**
          *@Description: 根据车牌号查询用户表的名字
          *         * 再将名字、车牌号、停车场ID、进场时间存进TempParkData表
          *         * 并计算该停车场剩余车位
          *         * 将allParks表中的车位数修改
          *@params: [license, parkID, inTime]
          *@return: boolean
          **/

         String[] parma1= new String[1];
         String[] param2 = new String[4];
         try {
            //根据车牌号license 在userInfo中查询用户名userName
              String sql  = "select userName from userInfo where license = ?";
              parma1[0] = license;
              System.out.println("进停车" + license);
              PreparedStatement ps  = excuteSQL(sql,1,parma1);
              ResultSet rs1 =  ps.executeQuery();
              String userName = null;
              if (rs1.next()){
                  userName =  rs1.getString("userName");
              }
              System.out.println("进停车场查询用户名" + userName);
              // 将查询到的userName，parkID，license，inTime信息存进tempParkData中

              sql = "insert into tempParkData(userName,parkID,license,inTime) values (?,?,?,?)";
              param2[0] = userName;
              param2[1] = parkID;
              param2[2] = license;
              param2[3] = inTime;
              ps  = excuteSQL(sql,4,param2);
              if (ps.executeUpdate() != 0){

                  System.out.println("进停车场插入数据tempParkData");
                  //更新停车场parkID的车位占用数量
                  updateParkingSpace(parkID);
                  System.out.println("进停车场更新车位数");
              }
       }catch (SQLException e){
              e.printStackTrace();
          }
         return JSONArray.toJSONString(param2);

    }

    public String outPark(String license, String parkID,String outTime){

        /**
         *@Description: 出停车场，需将tempParkData表中的该车牌号信息查找出来，
         *     *再将信息插入parkHistoryInfo
         *     * 并删除tempParkData的这条记录
         *     * 更新allParks停车位
         *@params: [license, parkID, outTime]
         *@return: boolean
         **/
        String[] param1 = new String[1];
        String[] param2 = new String[5];
        try {
            // 1.通过车牌号查询tempParkData的记录
            param1[0] = license;
            String sql = "select userName,parkID,license,inTime from tempParkData where license = ?";
            PreparedStatement ps = excuteSQL(sql,1,param1);

            ResultSet rs1 = ps.executeQuery();
            while (rs1.next()){
                System.out.println("出停车场查询车牌号记录");
                // 2. 将上述查询的记录存进parkHistoryInfo中
                param2[0] = rs1.getString("userName");
                param2[1] = rs1.getString("parkID");
                param2[2] = rs1.getString("inTime");
                param2[3] = outTime;
                param2[4] = rs1.getString("license");

                sql = "insert into parkHistoryInfo(userName,parkID,inTime,outTime,license) values(?,?,?,?,?)";
                ps = excuteSQL(sql,5,param2);
                if (ps.executeUpdate() == 1){
                    System.out.println("出停车场将记录存进parkHistory表中");

                    // 3. 将tempParkData查询的记录删除
                    String[] param3 = new String[1];
                    sql = "delete from tempParkData where license = ?";
                    param3[0] = license;
                    ps = excuteSQL(sql,1,param3);

                    if (ps.executeUpdate() != 0){
                        System.out.println("出停车场将tempParkData记录删除");
                        //将总停车场的表的车位数更新
                        updateParkingSpace(parkID);
                        System.out.println("出停车场更新总车位数");
                    }
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return JSONArray.toJSONString(param2);
    }

  /*  public String selectMessageFromTempPark(String userName){

        *//**
         *@Description: 根据用户名，从临时停车场中查询出对应车主信息返回给前端
         *@params: [userName]
         *@return: java.lang.String
         **//*

        try {

            String sql = "select userName,license,parkID,inTime from tempParkData where userName = ?";
          *//*  PreparedStatement ps = con.getCon().prepareStatement(sql);
            ps.setString(1,userName);*//*
            String[] param = new String[1];
            PreparedStatement ps = excuteSQL(sql,1,param) ;
            ResultSet rs =  ps.executeQuery();
            String[] message = new String[4];
            if(rs.next()){
                message[0] = rs.getString("userName");
                message[1] = rs.getString("license");
                message[2] = rs.getString("parkID");
                message[3] = rs.getString("inTime");
                messageFromImg =  JSONArray.toJSONString(message);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.getCon().close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return messageFromImg;
    }*/



}
