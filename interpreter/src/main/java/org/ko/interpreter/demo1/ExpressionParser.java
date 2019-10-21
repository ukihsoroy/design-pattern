package org.ko.interpreter.demo1;

import java.util.Stack;

/**
 * 格式化表达式
 */
public class ExpressionParser {

    private Stack<Interpreter> stack = new Stack<>();

    public int parse (String expression) {
        String[] itemArray = expression.split(" ");
        for (String symbol : itemArray) {
            if (!OperatorUtil.isOperator(symbol)) {
                Interpreter numberExpression = new NumberInterpreter(symbol);
                stack.push(numberExpression);
                System.out.println(String.format("入栈： %d", numberExpression.interpret()));
            } else {
                //是运算符可以计算
                Interpreter firstExpression = stack.pop();
                Interpreter secondExpression = stack.pop();
                System.out.println(String.format("出栈：%d 和 %d", firstExpression.interpret(),
                        secondExpression.interpret()));
                Interpreter operator = OperatorUtil.getExpression(firstExpression, secondExpression, symbol);
                System.out.println(String.format("应用运算符: %s", operator));
                int result = operator.interpret();
                NumberInterpreter numberInterpreter = new NumberInterpreter(result);
                stack.push(numberInterpreter);
                System.out.println(String.format("阶段结果入栈: %d", result));
            }
        }
        return stack.pop().interpret();
    }
}
