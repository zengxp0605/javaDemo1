package com.jason.mybatisxml.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class UserFamily implements Serializable {

    public static final long serialVersionUID = 1L;
    private Long id;
    private Long userId;
    private Long familyId;
    private String familyRole;

    public UserFamily() {
    }

    public UserFamily(Long userId, Long familyId, String familyRole) {
        this.userId = userId;
        this.familyId = familyId;
        this.familyRole = familyRole;
    }
}
