package org.ko.interpreter.demo1;

/**
 * 工具类
 */
public class OperatorUtil {

    public static boolean isOperator(String symbol) {
        return (symbol.equals("+") || symbol.equals("*"));
    }

    public static Interpreter getExpression(Interpreter first,
                                            Interpreter second,
                                            String symbol) {
        switch (symbol) {
            case "+":
                return new AddInterpreter(first, second);
            case "*":
                return new MultiInterpreter(first, second);
            default:
                return null;
        }
    }
}
