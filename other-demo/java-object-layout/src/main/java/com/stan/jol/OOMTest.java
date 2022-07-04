package com.stan.jol;

import java.io.Serializable;

/**
 * @author zengxp
 */
public class OOMTest {
    public static void main(String[] args) {

    }

   static class BaseDTO implements Serializable {
        private static final long serialVersionUID = 1603075924416461577L;

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }

    }

}
