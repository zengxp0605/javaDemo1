package com.jason.myannotation.controller;

import com.jason.myannotation.annotations.LogManage;
import com.jason.myannotation.entity.User;
import com.jason.myannotation.service.TableGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class IndexController {

    @Autowired
    private TableGenerator tableGenerator;

    @RequestMapping("/")
    @LogManage(value = "test", desc = "首页日志")
    public String index() {
        File file = new File(""); // 设定为当前文件夹
        String classPath = "";
        try {
            String path = file.getAbsolutePath();
            System.out.println("path: " + file.getAbsolutePath());

            File f = new File(this.getClass().getResource("").getPath());
            System.out.println(f);
            return "Welcome: " + f;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Welcome .";
    }

    /**
     * 获取创建 user类映射的建表 sql语句
     * @return
     */
    @RequestMapping("/getSql")
    public String getSql() {
        try {
            return tableGenerator.genSQL(User.class);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
