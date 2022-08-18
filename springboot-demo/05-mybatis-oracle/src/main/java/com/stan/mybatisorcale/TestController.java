package com.stan.mybatisorcale;

import com.stan.mybatisorcale.dal.Dog;
import com.stan.mybatisorcale.dal.DogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DogMapper dogMapper;

    @RequestMapping("/jdbc")
    public Object jdbc(){
        List<Dog> list = jdbcTemplate.query("select * from dog", new BeanPropertyRowMapper<>(Dog.class));
        log.info("jdbc res: {}", list);
        return list;
    }

    @RequestMapping("/")
    public Object mybatis(){
        List<Dog> list = dogMapper.getAll();
        log.info("mybatis res: {}", list);
        return list;
    }
}
