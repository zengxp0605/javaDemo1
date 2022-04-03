package com.jason.groovytst.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Member {

    private long id;

    private String memberNo;

    private int activeStatus;

    private String userSex;

    private String userName;

}
