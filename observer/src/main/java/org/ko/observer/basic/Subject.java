package org.ko.observer.basic;

import java.util.List;

/**
 * 被观察实例抽象定义
 */
public abstract class Subject {

    /**
     * 观察者数组
     */
    protected List<Observer> observers;

    /**
     * 添加一个观察者
     * @param observer
     */
    public abstract void add(Observer observer);

    /**
     * 删除一个观察者
     * @param observer
     */
    public abstract void remove(Observer observer);


    /**
     * 通知观察者
     */
    public abstract void notifyObserver();
}
