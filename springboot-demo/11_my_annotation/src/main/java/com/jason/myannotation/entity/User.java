package com.jason.myannotation.entity;

import com.jason.myannotation.annotations.MyColumn;
import com.jason.myannotation.annotations.MyConstraints;
import com.jason.myannotation.annotations.MyTable;

@MyTable("t_user")
public class User {

    @MyColumn(value = "id", constraints = @MyConstraints(primaryKey = true))
    private String id;

    @MyColumn(value = "name")
    private String name;

    @MyColumn(value = "age", type = "INT", constraints = @MyConstraints(nullable = true))
    private int age;

    @MyColumn(value = "phone_nuber", constraints = @MyConstraints(unique = true))
    private String phoneNumber;
}
