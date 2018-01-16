package com.yunsu.web;

import com.yunsu.domain.Register;
import com.yunsu.domain.User;
import com.yunsu.service.RegisterUserService;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.InitBinderDataBinderFactory;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class RegisterController{

    public RegisterController(){
        super();
    }

    @Resource
    private RegisterUserService registerUserService;

    @RequestMapping("/first")
    public String first(){
        return "login";
    }

    @RequestMapping("insertUser")
    public String insertUser(){
        return "regPage";
    }

    @RequestMapping("findUserByName")
    public ModelAndView findUserByName(HttpServletRequest request, Register register){
//        System.out.println(register.getUname());
        ModelAndView modelAndView = new ModelAndView();
        Register reg = registerUserService.findUserByName(register.getUname());
        if(register.getUpassword().equals(reg.getUpassword())){
            List<User> list = registerUserService.findAll();

            request.getSession().setAttribute("register",register);
            request.getSession().setAttribute("listA", list);

            modelAndView.setViewName("home");
            modelAndView.addObject("listA",list);
            return modelAndView;
        }
        modelAndView.setViewName("login");
       return modelAndView;
    }

    @RequestMapping("RegSuc")
    public String RegSuc(Register register){
        registerUserService.insertUser(register);
        return "success";
    }

    @RequestMapping("addUser")
    public String addUser(){
        return "addUser";
    }

    @RequestMapping("save")
    public String save(HttpServletRequest request, User user){
        System.out.println(user.getUname());
        registerUserService.insertAddUser(user);
        List<User> list = registerUserService.findAll();

        request.getSession().setAttribute("user",user);
        request.getSession().setAttribute("listA", list);
        return "home";
    }

    @RequestMapping("/findUser")
    public String findUser(HttpServletRequest request,String name){
        User u = registerUserService.findByName(name);

        request.getSession().setAttribute("u", u);
        return "userDetail";
    }

    @RequestMapping("/editUser")
    public String editUser(HttpServletRequest request, User user){
        User u = (User) request.getSession().getAttribute("u");
        User us = registerUserService.findByName(u.getUname());

        System.out.println(u.getUname());
        System.out.println(user.getUname());
        System.out.println(us.getUname());

        if(!user.getUname().equals(us.getUname())){
            registerUserService.insertAddUser(user);
        }else{
            registerUserService.updateUser(user);
        }

        return "home";
    }

//    @RequestMapping("save")
//    public ModelAndView save(User user){
//        ModelAndView mv = new ModelAndView();
//
//        mv.addObject("user", user);
//        mv.setViewName("home");
//
//        return mv;
//    }

    @InitBinder
    public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
