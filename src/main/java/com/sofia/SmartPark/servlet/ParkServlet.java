package com.sofia.SmartPark.servlet;

import com.alibaba.fastjson.JSONArray;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/LisenceServlet")

public class ParkServlet extends HttpServlet {
    public static String messageFromImg = "";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String license  = request.getParameter("License");
        license = new String(license.getBytes("iso8859-1"),"utf-8");
        String id = request.getParameter("parkID");
        String time = request.getParameter("Time");
      /*  System.out.println(id);
        System.out.println(time);
        System.out.println(license);*/

        ServletSQL servletSQL  = new ServletSQL();
        if (!servletSQL.hasLicenseInPark(license,id)){
            System.out.println("进停车场");

            messageFromImg = servletSQL.inPark(license,id,time);
            System.out.println(messageFromImg);
        }else{
            System.out.println("出停车场");
            messageFromImg = servletSQL.outPark(license,id,time);
            System.out.println(messageFromImg);
        }


    }
}
