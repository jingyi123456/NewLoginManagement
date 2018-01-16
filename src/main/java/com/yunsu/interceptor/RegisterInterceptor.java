package com.yunsu.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getRequestURI().indexOf("login") >= 0){
            return true;
        }
        if(request.getRequestURI().indexOf("findUserByName") >= 0){
            return true;
        }
        if(request.getRequestURI().indexOf("insertUser") >= 0){
            return true;
        }

        HttpSession session = request.getSession();
        if(session.getAttribute("register") != null){
            return true;
        }

        request.getRequestDispatcher("WEB-INF/jsps/login.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
