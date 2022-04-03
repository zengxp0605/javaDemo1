package com.jason.basejava.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class IndexController {

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "Test index";
    }

    /**
     * 异常处理
     * @return
     */
    @RequestMapping("/err")
    public String errTest(){
        int a = 1 / 0;
        return "Test index";
    }

    @RequestMapping("/getJson")
    @ResponseBody
    public JsonBean getJson(){
        JsonBean jsonBean = new JsonBean();

        jsonBean.setBirthday(new Date());
        jsonBean.setName("test2");
        List<String> stringList = new ArrayList();
        stringList.add("1111@qq.com");
        stringList.add("2345566@qq.com");
        stringList.add("123566@qq.com");
        jsonBean.setQqList(stringList);
        return jsonBean;
    }

    class JsonBean {
        private String name;
        @JsonFormat(timezone = "yyyy年MM月dd日")
        private Date birthday;
        private List<String> qqList;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getBirthday() {
            return birthday;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }

        public List<String> getQqList() {
            return qqList;
        }

        public void setQqList(List<String> qqList) {
            this.qqList = qqList;
        }
    }
}
