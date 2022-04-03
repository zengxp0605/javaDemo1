package com.stan.enableAnno2;

import com.stan.enableAnno2.annotations.EnableAnnoXJob;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAnnoXJob("com.stan.enableAnno2.useClient")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
