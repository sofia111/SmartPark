package com.sofia.SmartPark.common;

import com.alibaba.fastjson.JSONObject;
import com.sofia.SmartPark.beans.ResultData;
import com.sofia.SmartPark.exception.CustomException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SpringExceptionResolver implements HandlerExceptionResolver {
    private static final Logger logger = LoggerFactory.getLogger(SpringExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception exception) {
        String url = httpServletRequest.getRequestURL().toString();
        String defaultMsg = "System error";
        ResultData resultData;
        if(exception instanceof CustomException) {
            resultData = ResultData.fail(exception.getMessage());
            logger.error("自定义异常, url: {}", url, exception);
        } else {
            resultData = ResultData.fail(defaultMsg);
            logger.error("系统异常, url: {}", url, exception);
        }
        PrintWriter writer = null;
        try {
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            writer = httpServletResponse.getWriter();
            String msg = JSONObject.toJSONString(resultData);
            if(StringUtils.isNotBlank(msg)) {
                writer.write(msg);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("系统异常, PrintWriter写入异常");
        } finally {
            if(writer != null) {
                writer.close();
            }
        }
        return null;
    }

}
