package com.sofia.SmartPark.servlet;

import java.sql.*;

/**
*@Author: Sofia
*@Email: feng-sofia@foxmail.com
*@Date: 2019/4/15 9:39
*@Description: 连接数据库
*/
public class DBConnection {

    public Connection getCon(){
        try{
            String drive = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://120.79.212.22/SmartPark?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&useSSL=true";
            Connection connection = null;
            Class.forName(drive);
            connection = DriverManager.getConnection(url,"root","Xiao1234!");
            return connection;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }



}
