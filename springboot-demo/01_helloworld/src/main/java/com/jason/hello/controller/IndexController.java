package com.jason.hello.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Enumeration;

@Controller
public class IndexController {

    @GetMapping(path = "/")
    public String index(){
        return "index";
    }

    @GetMapping(path = "/getJson")
    @ResponseBody
    public Object getJson(){
        JSONObject jsonObject = JSONObject.parseObject("{\"date\":\"2019-07-24 17:44:19\", \"id\":1, \"string\":\"fastjson test\"}");
        return jsonObject;
    }

    @GetMapping("/download")
    public void download(HttpServletResponse response, HttpServletRequest request) {
        try {
            Enumeration<String> headerNames = request.getHeaderNames();
            String filePath = "/Users/stan/tmp.mp4";
            FileInputStream is = new FileInputStream(filePath);

//            InputStream is = new ByteArrayInputStream(bytes);

            // 配置文件下载
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            // 下载文件能正常显示中文
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("test_file.mp4", "UTF-8"));
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[1024];
            int len;
            int i = 0;
            while ((len = is.read(b)) != -1) {
                os.write(b, 0, len);
                System.out.println("文件写入：" + (i++));
            }

            System.out.println("download结束");
            is.close();
            os.close();
        } catch (Exception e) {
            System.out.println("下载文件异常" + e);
        }
    }
}
