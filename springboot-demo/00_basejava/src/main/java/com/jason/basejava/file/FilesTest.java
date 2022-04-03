package com.jason.basejava.file;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesTest {

    private static String rootPath = "d:/temp/out";

    public static void main(String[] args) throws Exception {
        Path path = Paths.get(rootPath);
        if(Files.exists(path)){
            Files.list(path).forEach(pathItem -> { // //pathItem代表一个子文件/文件夹的Path对象
                System.out.println("pathItem: " + pathItem);
                try {
                    Files.deleteIfExists(pathItem);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            Files.deleteIfExists(path);
        }

        // 创建文件夹
        Files.createDirectory(path);
        Files.createDirectory(Paths.get(rootPath + "/testDir"));

        // 写入文件
        byte[] bytes = new byte[]{65, 66, 97, 98}; // ASCII码 ABab
        Files.write( Paths.get(rootPath + "/1.txt"), bytes);

        //列出该文件夹下所有子文件、子文件夹的路径。
        Files.list(path).forEach(pathItem -> { // //pathItem代表一个子文件/文件夹的Path对象
            System.out.println("pathItem: " + pathItem);
            try {
                Files.lines(pathItem).forEach(line -> System.out.println(line));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // 文件夹详情
        FileStore store=Files.getFileStore(path);
        System.out.println("总大小: " + store.getTotalSpace());   //总大小。字节数
        System.out.println("可用大小: " + store.getUsableSpace());  //可用大小

    }
}
