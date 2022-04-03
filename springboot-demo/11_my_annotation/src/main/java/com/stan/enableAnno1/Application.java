package com.stan.enableAnno1;

import com.stan.enableAnno1.annotations.EnableAnnoXJob;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAnnoXJob("com.stan.testPackage")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
