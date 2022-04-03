package com.stan.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * 使用@WebListener注解将实现了ServletContextListener接口的MyServletContextListener标注为监听器
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[MyServletContextListener]ServletContex初始化");
        System.out.println("[MyServletContextListener]ServerInfo: "
                + sce.getServletContext().getServerInfo());
    }

    // 关闭服务时会调用
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContex销毁");
    }
}
