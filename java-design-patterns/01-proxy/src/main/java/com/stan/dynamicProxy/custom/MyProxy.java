package com.stan.dynamicProxy.custom;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.file.Paths;

/**
 * 生成代理对象的代码
 */
public class MyProxy {

    private static final String ln = "\n";

    public static Object newProxyInstance(MyClassLoader classLoader,
                                          Class<?>[] interfaces, MyInvocationHandler h) {

        // 需要动态生成， 这里先写死
        String className = "$Proxy0";

        /** 1. 生成代理对象的源代码 */
        String codeStr = generateSourceCode(interfaces[0], className, h.getClass().getPackage().getName());

        /** 2. 将源代码保存到磁盘  .java文件  */
        File javaFile = saveJavaFile(className, codeStr);

        /** 3. 编译源代码 生成 .class文件   */
        compileJavaFile(javaFile);

        try {
            /** 4. 将 .class文件动态加载到 JVM中  */
            Class<?> proxyClass = classLoader.findClass(className);
            Constructor<?> constructor = proxyClass.getConstructor(MyInvocationHandler.class);
            /** 5. 返回被代理后的对象  */
            return constructor.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 编译成 .class文件
     *
     * @param javaFile
     */
    private static void compileJavaFile(File javaFile) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> iterable = fileManager.getJavaFileObjects(javaFile);

        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, iterable);
        task.call();
        try {
            fileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 编译完删除源文件
        javaFile.delete();
    }

    /**
     * 保存java 文件
     *
     * @param className
     * @param codeStr
     */
    private static File saveJavaFile(String className, String codeStr) {
        String path = MyProxy.class.getResource("").getPath();
        String filePath = Paths.get(path, className + ".java").toString();
        System.out.println("生成的java文件路径： " + filePath);
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(codeStr);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * 生成代码
     *
     * @param interfaceClazz
     * @param className
     * @return
     */
    private static String generateSourceCode(Class<?> interfaceClazz, String className, String sourcePackage) {
        StringBuffer buffer = new StringBuffer();

        Package clazzPackage = interfaceClazz.getPackage();
        System.out.println("clazzPackage: " + clazzPackage);
        buffer.append("package " + sourcePackage + ";" + ln);
        buffer.append("import java.lang.reflect.Method;" + ln);
        buffer.append("import " + interfaceClazz.getName() + ";" + ln);
        buffer.append("public final class " + className + " extends MyProxy implements Person {" + ln);

        // 构造函数
        buffer.append("private MyInvocationHandler h;" + ln);
        buffer.append("public " + className + "(MyInvocationHandler h){ this.h = h; }" + ln);

        // 实现接口方法
        for (Method method : interfaceClazz.getMethods()) {
            buffer.append("public " + method.getReturnType().getName() + " " + method.getName() + "() {" + ln);
            buffer.append("try {" + ln);
            buffer.append("  Method m = " + interfaceClazz.getName() + ".class.getMethod(\"" + method.getName() + "\");" + ln);
            buffer.append("  return this.h.invoke(this, m, null);" + ln);
            buffer.append("} catch (Throwable throwable) {throwable.printStackTrace();}" + ln);
            buffer.append("  return null;" + ln);
            buffer.append("}" + ln);
        }

        buffer.append("}" + ln);
        return buffer.toString();
    }

}
