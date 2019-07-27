package org.ko.adapter.basic.classadapter;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        adaptee.adapteeRequest();

        Target adapterTarget = new Adapter();
        adapterTarget.request();
    }
}
