package com.controllers;

import com.models.User;
import com.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response){

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        LoginService ls = new LoginService();
        User loggedInUser = ls.getUser(email, password);

        ModelAndView mv =  new ModelAndView();
        mv.setViewName("/display");
        mv.addObject("loggedInUser", loggedInUser);

        //return "display.jsp";

        return mv;
    }
}
