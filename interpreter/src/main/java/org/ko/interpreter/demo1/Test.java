package org.ko.interpreter.demo1;

/**
 * 测试类
 */
public class Test {

    public static void main(String[] args) {
        String input = "6 100 11 + *";
        ExpressionParser parser = new ExpressionParser();
        int result = parser.parse(input);
        System.out.println("解释器运算结果：" + result);
    }
}
