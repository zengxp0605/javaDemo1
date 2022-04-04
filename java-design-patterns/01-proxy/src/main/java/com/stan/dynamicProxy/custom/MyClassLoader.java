package com.stan.dynamicProxy.custom;

import java.io.*;

/**
 * 自定义的类加载器
 * 代码编译，动态load到JVM中
 */
public class MyClassLoader extends ClassLoader {

    private File baseDir;

    public MyClassLoader() {
        String path = this.getClass().getResource("").getPath();
        this.baseDir = new File(path);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass name: " + name);
        String className = this.getClass().getPackage().getName() + "." + name;
        System.out.println("findClass className: " + className);

        String classFilePath = name.replaceAll("\\.", "/") + ".class";
        File classFile = new File(this.baseDir, classFilePath);
        if (!classFile.exists()) {
            System.out.println("classFile 不存在，" + classFile.getName());
            return null;
        }

        InputStream is = null;
        ByteArrayOutputStream os = null;
        try {
            is = new FileInputStream(classFile);
            os = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int len;
            while ((len = is.read(buff)) != -1) {
                os.write(buff, 0, len);
            }
            return defineClass(className, os.toByteArray(), 0, os.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 最后删除.class文件
            classFile.delete();
        }

        return super.findClass(name);
    }


}
