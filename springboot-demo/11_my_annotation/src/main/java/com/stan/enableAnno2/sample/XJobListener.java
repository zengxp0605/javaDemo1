package com.stan.enableAnno2.sample;


import java.lang.reflect.Method;

public class XJobListener {
    private String name;
    private Method method;
    private Object bean;

    public String getName() {
        return name;
    }

    public XJobListener(String name, Method method, Object bean) {
        this.name = name;
        this.method = method;
        this.bean = bean;
    }

    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("job 被触发：" + jobExecutionContext);
        try {
            this.method.invoke(bean, jobExecutionContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("job 执行结果：" + jobExecutionContext);
    }
}
