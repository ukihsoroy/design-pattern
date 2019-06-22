package org.ko.prototype.singleton;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        //获取单例对象
        StaticInnerClassSingleton singleton = StaticInnerClassSingleton.getInstance();
        System.out.println(singleton.toString());

        //clone获取克隆对象
        StaticInnerClassSingleton singleton1 = (StaticInnerClassSingleton) singleton.clone();
        System.out.println(singleton1.toString());
    }
}
