package org.ko.prototype.singleton;

/**
 * 修改后的测试类
 */
public class Test1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        //获取单例对象
        StaticInnerClassSingleton1 singleton1 = StaticInnerClassSingleton1.getInstance();
        System.out.println(singleton1.toString());

        //获取clone对象
        StaticInnerClassSingleton1 singleton2 = (StaticInnerClassSingleton1) singleton1.clone();
        System.out.println(singleton2.toString());
    }
}
