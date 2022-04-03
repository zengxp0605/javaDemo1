package com.jason.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
public class Author {

    @Value("${author.name}")
    private String name;

    @Value("${author.age}")
    private int age;

    @Value("${author.gender}")
    private String gender;

    @Value("${author.introduce}")
    private String introduce;

    @Value("${uploadFile.tmpPath}")
    private String testStr;
}
