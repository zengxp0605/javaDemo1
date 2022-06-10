package com.stan.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author：zengxp
 * @date：2022/3/11 下午9:07
 */
@Controller
public class DownloadController {

    private static final Logger log = LoggerFactory.getLogger(DownloadController.class);

    @GetMapping("/test")
    @ResponseBody
    public String test(HttpServletResponse response, HttpServletRequest request) {
        return "test";
    }

    @GetMapping("/download2")
    public void download2(HttpServletResponse response, HttpServletRequest request) {
        try {
            Enumeration<String> headerNames = request.getHeaderNames();
            log.info("request---->");
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                String value = request.getHeader(name);
                log.info("request.{}={}", name, value);
            }

            String filePath = "/data/website/blog/downloads/harbor-offline-installer-v1.10.8.tgz";
            FileInputStream is = new FileInputStream(filePath);

//            response.setStatus(206);
            // 配置文件下载
            response.setHeader("content-type", "application/octet-stream");
            response.setHeader("Accept-Ranges", "bytes");
//            response.setHeader("Content-Range", "bytes 17941700-17941700/587643899");
            response.setContentType("application/octet-stream");
            // 下载文件能正常显示中文
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("test_file.mp4", "UTF-8"));
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[1024];
            int len;
            int i = 0;
            while ((len = is.read(b)) != -1) {
                os.write(b, 0, len);
//                log.info("文件写入：{}", i++);
                if (i++ % 100 == 0) {
                    Thread.sleep(50);
                }
            }

            log.info("download结束");
            is.close();
            os.close();
        } catch (Exception e) {
            log.error("下载文件异常：{}", e);
        }
    }


    @GetMapping("/download")
    public String download(HttpServletRequest request, HttpServletResponse response) {
        String filePath = "/Users/stan/tmp.mp4";
//        String filePath = "/data/website/blog/downloads/harbor-offline-installer-v1.10.8.tgz";
        File file = new File(filePath);
        if (file.exists()) {
            String range = request.getHeader("Range");
            log.info("range={}", range);
            if (range != null && (range = range.trim()).length() > 0) {
                Pattern rangePattern = Pattern.compile("^bytes=([0-9]+)-([0-9]+)?$");
                Matcher matcher = rangePattern.matcher(range);
                if (matcher.find()) {
                    Integer start = Integer.valueOf(matcher.group(1));
                    Integer end = 0;
                    String endStr = matcher.group(2);
                    if (endStr != null && (endStr = endStr.trim()).length() > 0)
                        end = Integer.valueOf(endStr);
                    breakPointService.downLoadByBreakpoint(file, start, end, response);
                    return null;
                }
            }
            breakPointService.downLoadAll(file, response);
            return null;
        }
        return "error";
    }

    @Autowired
    private BreakPointService breakPointService;

}
