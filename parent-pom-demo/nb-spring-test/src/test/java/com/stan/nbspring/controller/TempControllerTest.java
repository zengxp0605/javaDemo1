package com.stan.nbspring.controller;

import com.stan.nbspring.SpringTestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class TempControllerTest extends SpringTestBase {

    @Autowired
    TempController tempController;

    @Test
    public void test(){
        System.out.println(tempController.index());
    }
}