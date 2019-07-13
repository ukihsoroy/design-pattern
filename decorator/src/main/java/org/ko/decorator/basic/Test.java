package org.ko.decorator.basic;


/**
 * 应用与测试类
 */
public class Test {

    public static void main(String[] args) {
        //应用类
        IComponent component;

        //初始化
        component = new Component();

        //装饰
        component = new Decorator1(component);
        component = new Decorator2(component);

        //具体方法的调用
        component.operation();
    }
}
