package com.stan.shenyudemo.apachedubbo.test.consumer.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Classname SwaggerConfig
 * @Description TODO
 * 20/9/1 18:25
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {

        System.out.println("aaa--------->");
        return new Docket(DocumentationType.SWAGGER_2)
                //调用apiInfo方法,创建一个ApiInfo实例,里面是展示在文档页面信息内容
                .apiInfo(apiInfo())
                .select()
                //控制暴露出去的路径下的实例
                //如果某个接口不想暴露,可以使用以下注解
                //@ApiIgnore 这样,该接口就不会暴露在 swagger2 的页面下
//                .apis(RequestHandlerSelectors.basePackage("com.fosun.fosunwearcenter.iotweb.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * @Deccription 构建 api文档的详细信息函数
     * 20/9/1 18:53
     */
    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                //页面标题
                .title("Swagger2 接口文档 web版")
                //描述
                .description("后端接口")
                //创建人
                .contact(new Contact("卜相刚", "", "buxg@fosun.com"))
                //版本号
                .version("1.0")
                .build();
    }

}
