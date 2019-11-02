package org.ko.observer.basic;

/**
 * 观察者2
 */
public class ConcreteObserver2 implements Observer {
    @Override
    public void response() {
        System.out.println("通知观察者2");
    }
}
