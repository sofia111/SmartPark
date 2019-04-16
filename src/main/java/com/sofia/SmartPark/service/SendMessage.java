package com.sofia.SmartPark.service;

import com.sofia.SmartPark.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
*@Author: Sofia
*@Email: feng-sofia@foxmail.com
*@Date: 2019/4/15 9:38
*@Description: 注册时给手机发送验证码
*/
public class SendMessage {
    public String sendMessage(String mobile) {

          Random random = new Random();
                String verificationCode="";
                for (int i=0;i<6;i++)
                {
                    verificationCode+=random.nextInt(10);
                }
        String host = "https://cxkjsms.market.alicloudapi.com";
        String path = "/chuangxinsms/dxjk";
        String method = "POST";
        String appcode = "c697f95f15174b61b7c5de322065da15";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("content", "【智慧停车】验证码为："+verificationCode+"，欢迎注册！");
        querys.put("mobile", mobile);
        Map<String, String> bodys = new HashMap<String, String>();

        try {

            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);

            System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verificationCode;
    }
}

