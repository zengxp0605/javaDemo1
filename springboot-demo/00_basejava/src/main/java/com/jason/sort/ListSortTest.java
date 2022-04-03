package com.jason.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ListSortTest {


    public static void main(String[] args) {
        test1();
        test2();
    }

    /**
     * 使用lambda表达式
     */
    public static void test2() {
        System.out.println("====================test2=================");
        List<Student> list = getList();
        System.out.println("排序之前-----------------------");
        for(Student stu:list){
            System.out.println("id="+stu.getId()+" name="+stu.getName()+" score="+stu.getScore());
        }

        //排序l
        Collections.sort(list, (s1, s2)->s1.getScore()>s2.getScore() ? -1 : 1);

        System.out.println("排序之后-----------------------");
        for(Student stu:list){
            System.out.println("id="+stu.getId()+" name="+stu.getName()+" score="+stu.getScore());
        }

    }

    /**
     * 通过 Comparator
     */
    public static void test1() {
        System.out.println("====================test1=================");

        List<Student> list = getList();
        System.out.println("排序之前-----------------------");
        for(Student stu:list){
            System.out.println("id="+stu.getId()+" name="+stu.getName()+" score="+stu.getScore());
        }

        //排序l
        Collections.sort(list, new Comparator<Student>(){

            /**
             * return a negative integer, zero, or a positive integer as the first argument is less than,
             * 			equal to, or greater than the second.
             * 		//先按成绩 降序 排序，如果成绩一样的话按id 升序 排序
             */
            @Override
            public int compare(Student s1, Student s2) {

                if(s1.getScore()>s2.getScore()){	//greater
                    return -1;
                }else if(s1.getScore()==s2.getScore()){	//equals
                    if(s1.getId()>s2.getId()){
                        return 1;
                    }else if(s1.getId()==s2.getId()){
                        return 0;
                    }else{
                        return -1;
                    }
                }else{	//less
                    return 1;
                }
            }
        });

        System.out.println("排序之后-----------------------");
        for(Student stu:list){
            System.out.println("id="+stu.getId()+" name="+stu.getName()+" score="+stu.getScore());
        }
    }


    public static List<Student> getList() {
        Student s1 = new Student();
        s1.setId(10001);
        s1.setName("cat");
        s1.setScore(99.5f);

        Student s2 = new Student();
        s2.setId(10008);
        s2.setName("bba");
        s2.setScore(100.0f);

        Student s3 = new Student();
        s3.setId(10011);
        s3.setName("bac");
        s3.setScore(89.5f);

        List list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        return  list;
    }
}

