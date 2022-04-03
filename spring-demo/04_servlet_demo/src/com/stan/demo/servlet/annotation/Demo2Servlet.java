package com.stan.demo.servlet.annotation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 使用注解的方式实现, 不需要在 web.xml中配置了
 * http://localhost:8110/demo2
 * http://localhost:8110/demo2/get
 *
 */
@WebServlet(name = "Demo2Servlet", urlPatterns = {"/demo2", "/demo2/get"})
public class Demo2Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse res)
            throws ServletException, IOException {
        System.out.println("log from doPost");
        res.getWriter().println("Demo2Servlet -- doPost!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse res)
            throws ServletException, IOException {
        System.out.println("log from doGet");
        res.getWriter().println("Demo2Servlet -- doGet!");
    }

}
