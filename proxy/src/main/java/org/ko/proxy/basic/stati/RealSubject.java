package org.ko.proxy.basic.stati;

/**
 * @author zhiyuan.shen
 */
public class RealSubject implements Subject {
    @Override
    public void doAction() {
        System.out.println("service impl class.");
    }
}
