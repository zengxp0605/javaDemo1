package com.stan.jol;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author zengxp
 */
public class OOMTest {
    private static Random random = new Random();

    public static void main(String[] args) {
        ResponseDTO dto = new ResponseDTO();
        List<Object> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            byte[] bytes = new byte[1 * 1024 * 1024];
            list.add(new String(bytes));
        }

        dto.setList(list);
        String s = dto.toString();
//        System.out.println(s);
        System.out.println(s.length());
        System.out.println("end");
    }

    static class ResponseDTO extends BaseDTO {
        private List<Object> list;

        public List<Object> getList() {
            return list;
        }

        public void setList(List<Object> list) {
            this.list = list;
        }

        @Override
        public String toString() {
            return "ResponseDTO{" +
                    "list=" + super.toString() +
                    '}';
        }
    }

    static class BaseDTO implements Serializable {
        private static final long serialVersionUID = 123L;

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }

    }

}
