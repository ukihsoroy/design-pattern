package org.ko.observer.basic;

/**
 * 观察者1
 */
public class ConcreteObserver1 implements Observer {
    @Override
    public void response() {
        System.out.println("通知观察者1");
    }
}
