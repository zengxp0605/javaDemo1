package com.jason.groovytst.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Ignore
import spock.lang.Specification

@SpringBootTest
class HelloControllerTest extends Specification{

    @Autowired
    private HelloController  helloController


    def "Load helloController"(){
        expect: "the controller is created"
        helloController
    }
}
