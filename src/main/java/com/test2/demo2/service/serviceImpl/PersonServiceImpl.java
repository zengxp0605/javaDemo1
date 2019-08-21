package com.test2.demo2.service.serviceImpl;

import com.test2.demo2.bean.Person;
import com.test2.demo2.dao.PersonMapper;
import com.test2.demo2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<Person> getAllPerson(){
        return personMapper.selectByExample(null);
    }
}
