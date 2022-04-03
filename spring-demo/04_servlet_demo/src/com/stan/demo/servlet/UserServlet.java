package com.stan.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse res)
            throws ServletException, IOException {
        System.out.println("log from doPost");
        res.getWriter().println("UserServlet -- doPost!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse res)
            throws ServletException, IOException {
        System.out.println("log from doGet");
        res.getWriter().println("UserServlet -- doGet!");
    }

}
