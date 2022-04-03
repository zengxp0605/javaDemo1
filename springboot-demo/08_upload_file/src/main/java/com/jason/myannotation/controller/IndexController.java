package com.jason.myannotation.controller;

import com.jason.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private Author author;

    @RequestMapping("/getAuthor")
    public Author getAuthor(){
        System.out.println("Client get author: " + author);
        return author;
    }
}
