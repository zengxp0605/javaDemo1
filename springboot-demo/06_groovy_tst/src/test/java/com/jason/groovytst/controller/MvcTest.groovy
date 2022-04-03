package com.jason.groovytst.controller

import com.jason.groovytst.service.MyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
@WebMvcTest
class MvcTest extends Specification{

    @Autowired
    private MockMvc mockMvc

    def "获取index内容为'Hello Groovy.' "(){
        expect: "Status is 200 and the response is 'Hello Groovy.'"
        mockMvc.perform(get("/groovytst/index"))
                .andExpect(status().isOk())
                .andReturn()
                .response
                .contentAsString == "Hello Groovy."
    }

    def "test Parameterized"() {
        when:
        MyService myService = new MyService()
        then:
        myService.add(a, b) == result

        where: "准备参数，输入参数名必须跟方法里面的参数名一致"
        a | b || result
        1 | 1 || 2
        1 | 2 || 3
        2 | 2 || 4
    }

}
