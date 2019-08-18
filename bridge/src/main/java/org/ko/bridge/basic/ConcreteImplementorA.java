package org.ko.bridge.basic;

/**
 * 接口抽象实现1
 */
public class ConcreteImplementorA implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("桥接A");
    }
}
