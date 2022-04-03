package com.stan.enableAnno2;

import com.stan.enableAnno2.sample.JobExecutionContext;
import com.stan.enableAnno2.sample.XJobListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模拟admin 后台rpc调用 job任务
 */
@RestController
public class IndexController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/xJob")
    public Object xJob(
            @RequestParam String jobName,
            @RequestParam(required = false, defaultValue = "") String param
    ) {
        try {
            XJobListener xJobListener = applicationContext.getBean(jobName, XJobListener.class);
            JobExecutionContext jobExecutionContext = new JobExecutionContext() {{
                setJobId("x-job-id-" + System.currentTimeMillis());
                setParameter(param);
            }};
            xJobListener.execute(jobExecutionContext);

            System.out.println(jobExecutionContext);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "ok";
    }
}
