package com.jasontask.controller;

import com.jasontask.service.AsyncTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.concurrent.Future;

@RestController
public class IndexController {

    @Autowired
    private AsyncTaskService asyncTaskService;

    @RequestMapping("/")
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

    @RequestMapping("/asyncTask")
    public String asyncTask() {
        long start = System.currentTimeMillis();

        try {
            Future<Boolean> a = asyncTaskService.doTask1();
            Future<Boolean> b = asyncTaskService.doTask2();

            while (!a.isDone() || !b.isDone()) {
                if (a.isDone() && b.isDone()) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        String usedTime = "任务全部完成,总耗时: " + (end - start) + " 毫秒";
        System.out.println(usedTime);
        return usedTime;
    }
}
