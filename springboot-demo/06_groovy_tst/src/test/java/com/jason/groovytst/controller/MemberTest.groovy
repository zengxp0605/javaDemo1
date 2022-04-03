package com.jason.groovytst.controller

import com.jason.groovytst.entity.Member
import com.jason.groovytst.mapper.UserMapper
import com.jason.groovytst.service.MyService
import spock.lang.Specification

class MemberTest extends Specification {

    def userMapper = Mock(UserMapper)

    def "User isMan"(){
        given:
        userMapper.getOne(_) >> member

        when:
        MyService myService =new MyService()
        def result = myService.isMan(41)
        then:
        result != null

        where:
        member                               | activated
        null                                 | false
        new Member(id: 41)                   | false
        new Member(id: 41, userSex: "MAN")   | true
        new Member(id: 41, userSex: "WOMAN") | false
        new Member(id: 41, userSex: "MAN")   | true

    }


}
