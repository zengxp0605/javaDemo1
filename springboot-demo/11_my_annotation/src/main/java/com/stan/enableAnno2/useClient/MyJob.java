package com.stan.enableAnno2.useClient;

import com.stan.enableAnno2.annotations.XJobHandler;
import com.stan.enableAnno2.sample.JobExecutionContext;
import org.springframework.stereotype.Component;

/**
 * 配置job
 */
@Component
public class MyJob {
    @XJobHandler("firstDemoJob")
    public void firstDemoJob(JobExecutionContext jobExecutionContext) {
        System.out.println("firstDemoJob执行，参数:" + jobExecutionContext.getParameter());
        jobExecutionContext.setSuccess(true);
    }

    @XJobHandler("secondJob")
    public void secondJob(JobExecutionContext jobExecutionContext) {
        System.out.println("secondJob执行，参数: " + jobExecutionContext.getParameter());
        jobExecutionContext.setSuccess(false);
    }
}
