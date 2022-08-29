package com.jason.spel;

import org.springframework.context.expression.MethodBasedEvaluationContext;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.lang.reflect.Method;

/**
 *  Spring 表达式语言 (SpEL)
 */
public class SpEL_demo {

    public static void main(String[] args) {
        Demo.main(args);
        System.out.println("---------------------");
        Method fun = null;

        Demo target = new Demo();
        Method[] methods = Demo.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals("fun1")) {
                fun = method;
                break;
            }
        }

        assert fun != null;

        Object[] funArgs = new Object[]{1L, "stan", "12345", 30};
        EvaluationContext evaluationContext = new MethodBasedEvaluationContext(target, fun, funArgs, new DefaultParameterNameDiscoverer());

        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("#a0");
        Object a0 = expression.getValue(evaluationContext);
        System.out.println("a0: " + a0); // 1L

        Object a1 = parser.parseExpression("#a1").getValue(evaluationContext);
        System.out.println("a1: " + a1); //

        Object p2 = parser.parseExpression("#p2").getValue(evaluationContext);
        System.out.println("p2: " + p2); //

        Object thirdNo = parser.parseExpression("#thirdNo").getValue(evaluationContext);
        System.out.println("thirdNo: " + thirdNo); // 12345

        Object age = parser.parseExpression("#age").getValue(evaluationContext);
        System.out.println("age: " + age); // 30
    }


    static class Demo {
        public String fun1(Long id, String name, String thirdNo, Integer age) {
            return "ok";
        }

        public static void main(String[] args) {
            ExpressionParser parser = new SpelExpressionParser();
            Expression exp = parser.parseExpression("'Hello World'.concat('!')");
            String message = (String) exp.getValue();
            System.out.println("合并字符: " + message);

            Object bytesLength = parser.parseExpression("'Hello World'.bytes.length").getValue();
            System.out.println("bytesLength: " + bytesLength);
        }
    }
}
