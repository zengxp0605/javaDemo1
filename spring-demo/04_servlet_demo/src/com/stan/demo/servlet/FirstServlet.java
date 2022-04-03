package com.stan.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstServlet extends HttpServlet {

    // 如果重写了 service, 则不会执行下面的 doGet doPost
    // 父类是通过 service 分配 doGet doPost
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse res)
//            throws ServletException, IOException {
//        System.out.println("Request from /hello.");
//        res.getWriter().println("Hello World!");
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse res)
            throws ServletException, IOException {
        System.out.println("log from doPost");
        res.getWriter().println("Hello World-- doPost!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse res)
            throws ServletException, IOException {
        System.out.println("log from doGet");
        res.getWriter().println("Hello World-- doGet!");
    }

}
