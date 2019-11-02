package org.ko.observer.basic;

import java.util.ArrayList;

/**
 * 被观察的实例
 */
public class ConcreteSubject extends Subject {

    public ConcreteSubject() {
        super.observers = new ArrayList<>();
    }

    @Override
    public void add(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : this.observers) {
            observer.response();
        }
    }
}
