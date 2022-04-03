package com.stan.enableAnno2.sample;

import com.stan.enableAnno2.annotations.EnableAnnoXJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

@Configuration
public class MyAutoConfiguration implements ImportAware {
    private AnnotationMetadata annotationMetadata;
    @Override
    public void setImportMetadata(AnnotationMetadata annotationMetadata) {
        System.out.println("annotationMetadata: " + annotationMetadata);
        this.annotationMetadata = annotationMetadata;
    }

    /**
     * 配置 XJobCommandLineRunner
     * @return
     */
    @Bean
    public XJobCommandLineRunner xJobCommandLineRunner(){
        return new XJobCommandLineRunner();
    }

    /**
     * 模拟其他类解析 EnableAnnoXJob注解的内容
     * @return
     */
    @Bean
    public XJobBeanPostProcessor xJobBeanPostProcessor() {
        XJobBeanPostProcessor XJobBeanPostProcessor = new XJobBeanPostProcessor();

        Map<String, Object> attributesMap = annotationMetadata.getAnnotationAttributes(EnableAnnoXJob.class.getName());

        System.out.println("attributesMap: " + attributesMap);
        AnnotationAttributes enableAnnoXJob = AnnotationAttributes.fromMap(attributesMap);

        String basePackage = enableAnnoXJob.getString("basePackage");
        int aDefaultVal = enableAnnoXJob.getNumber("aDefaultVal");
        System.out.println("basePackage: " + basePackage);
        System.out.println("aDefaultVal: " + aDefaultVal);
        XJobBeanPostProcessor.setConfigPackage(basePackage);
        return XJobBeanPostProcessor;
    }
}
