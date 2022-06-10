package com.stan.demo;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author：zengxp
 * @date：2022/6/9 下午5:24
 */
@Service
public class BreakPointService {

    //断点续传
    public void downLoadByBreakpoint(File file, long start, long end, HttpServletResponse response) {
        OutputStream stream = null;
        RandomAccessFile fif = null;
        try {
            if (end <= 0) {
                end = file.length() - 1;
            }
            stream = response.getOutputStream();
            response.reset();
            response.setStatus(206);
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment; filename=" + file.getName());
            response.setHeader("Content-Length", String.valueOf(end - start + 1));
            response.setHeader("file-size", String.valueOf(file.length()));
            response.setHeader("Accept-Ranges", "bytes");
            response.setHeader("Content-Range", String.format("bytes %s-%s/%s", start, end, file.length()));
            fif = new RandomAccessFile(file, "r");
            fif.seek(start);
            long index = start;
            int d;
            byte[] buf = new byte[10240];
            while (index <= end && (d = fif.read(buf)) != -1) {
                if (index + d > end) {
                    d = (int) (end - index + 1);
                }
                index += d;
                stream.write(buf, 0, d);
            }
            stream.flush();
        } catch (Exception e) {
            try {
                if (stream != null)
                    stream.close();
                if (fif != null)
                    fif.close();
            } catch (Exception e11) {
            }
        }
    }

    //全量下载
    public void downLoadAll(File file, HttpServletResponse response) {
        OutputStream stream = null;
        BufferedInputStream fif = null;
        try {
            stream = response.getOutputStream();
            response.reset();
            response.setContentType("application/octet-stream");
//            response.setHeader("Accept-Ranges", "bytes");
            response.setHeader("Content-disposition", "attachment; filename=" + file.getName());
            response.setHeader("Content-Length", String.valueOf(file.length()));
            response.setHeader("Accept-Ranges", "bytes");
            // 加上这个字段，浏览器才会缓存，接下来的续传请求头会带上 [Range: bytes=11730677-879931129]
            response.setHeader("ETag", "62a16c74-2306bbfb");

            fif = new BufferedInputStream(new FileInputStream(file));
            int d;
            byte[] buf = new byte[1024];
            int i = 0;
            while ((d = fif.read(buf)) != -1) {
                stream.write(buf, 0, d);
                // 让下载速度变慢
                if (i++ % 100 == 0) {
                    Thread.sleep(50);
                }
            }
            stream.flush();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (stream != null)
                    stream.close();
                if (fif != null)
                    fif.close();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

}
