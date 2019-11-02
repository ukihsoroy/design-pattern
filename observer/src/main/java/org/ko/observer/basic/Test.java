package org.ko.observer.basic;

/**
 * 测试与应用
 */
public class Test {

    public static void main(String[] args) {
        //创建实例
        Subject subject = new ConcreteSubject();

        //创建观察者对象
        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();

        //添加观察者对象
        subject.add(observer1);
        subject.add(observer2);

        //通知观察者
        subject.notifyObserver();
    }
}
