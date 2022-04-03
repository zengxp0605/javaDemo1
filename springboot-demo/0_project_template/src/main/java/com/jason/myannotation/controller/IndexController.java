package com.jason.myannotation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class IndexController {

    @RequestMapping("/")
    public String index(){
        File file = new File(""); // 设定为当前文件夹
        String classPath = "";
        try {
            String path = file.getAbsolutePath();
            System.out.println("path: " + file.getAbsolutePath());

            File f = new File(this.getClass().getResource("").getPath());
            System.out.println(f);
            return "Welcome: " + f;
        } catch (Exception e){
            e.printStackTrace();
        }
        return "Welcome .";
    }
}
