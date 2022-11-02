package com.stan.nbspring.controller;

import com.stan.nbspring.SpringTestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class UserAccountControllerTest extends SpringTestBase {

    @Autowired
    UserAccountController userAccountController;

    @Test
    public void list() {
        System.out.println("list: " + userAccountController.list());
    }
}