package com.sofia.SmartPark.interceptor;

import com.sofia.SmartPark.common.CookieSessionManage;
import com.sofia.SmartPark.common.RequestHolder;
import com.sofia.SmartPark.model.TbUser;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Object o) throws Exception{
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        String uri = httpServletRequest.getRequestURI();

        //不拦截静态文件

        //判断用户是否已经登录
        TbUser user = (TbUser) CookieSessionManage.getSession(httpServletRequest);
        if (user != null){
            RequestHolder.add(user);
            RequestHolder.add(httpServletRequest);
            return true;
        }
        return true; // workaround
        //httpServletResponse.sendRedirect("重定向页面url");
        //return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        RequestHolder.remove();
    }
}
