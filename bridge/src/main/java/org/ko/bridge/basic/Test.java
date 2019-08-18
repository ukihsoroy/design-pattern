package org.ko.bridge.basic;

/**
 * 测试与应用
 */
public class Test {

    public static void main(String[] args) {

        Abstraction abstraction1 = new RefinedAbstraction(new ConcreteImplementorA());
        Abstraction abstraction2 = new RefinedAbstraction(new ConcreteImplementorB());

        abstraction1.operation();
        abstraction2.operation();
    }
}
