package org.ko.proxy.demo1.dynamic.jdk.simple;


import org.ko.proxy.demo1.statics.Car;
import org.ko.proxy.demo1.statics.MoveAble;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);
        MoveAble moveable = (MoveAble)Proxy.newProxyInstance(MoveAble.class,h);
        moveable.move();
    }
}
