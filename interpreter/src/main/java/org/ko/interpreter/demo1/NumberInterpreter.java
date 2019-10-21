package org.ko.interpreter.demo1;


/**
 * 数值型表达式
 */
public class NumberInterpreter implements Interpreter {

    private int number;

    public NumberInterpreter(int number) {
        this.number = number;
    }

    public NumberInterpreter(String number){
        this.number = Integer.parseInt(number);
    }

    @Override
    public int interpret() {
        return this.number;
    }
}
