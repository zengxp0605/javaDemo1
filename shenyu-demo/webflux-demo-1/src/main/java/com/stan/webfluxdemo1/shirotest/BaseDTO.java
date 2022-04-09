package com.stan.webfluxdemo1.shirotest;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class BaseDTO implements Serializable {
    private static final long serialVersionUID = 1603075924416461577L;

}
