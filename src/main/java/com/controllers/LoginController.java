package com.controllers;

import com.models.StudentData;
import com.service.DatabaseConnection;
import com.service.StudentService;
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

        String snumber = request.getParameter("snumber");
        String sname = request.getParameter("sname");
        int gpa = request.getIntHeader("gpa");

        DatabaseConnection databaseConnection = new DatabaseConnection();
        StudentService ls = new StudentService(databaseConnection.getDatabaseConnection());
        StudentData loggedInUser = ls.getUser(snumber, sname, gpa);

        ModelAndView mv =  new ModelAndView();
        mv.setViewName("/display");
        mv.addObject("loggedInUser", loggedInUser);

        //return "display.jsp";

        return mv;
    }
}
