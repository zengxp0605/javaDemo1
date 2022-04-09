package com.stan.swagger.demo;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: zengxp
 * @Date: 2021/12/16 14:27
 * @Desc:
 */
@SpringBootApplication
public class Application {
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Configuration
    @EnableSwagger2
    public class SwaggerConfig {
        @Bean
        public Docket createRestApi() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                    .paths(PathSelectors.any())
                    .build();
        }

        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    //页面标题
                    .title("Swagger2 接口文档 web版")
                    //描述
                    .description("后端接口")
                    //创建人
                    .contact(new Contact("zxp", "", "zxp@example.com"))
                    //版本号
                    .version("1.0")
                    .build();
        }
    }
}