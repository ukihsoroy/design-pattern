package org.ko.adapter.basic.objectadapter;

/**
 * 应用测试类
 */
public class Test {

    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        adaptee.adapteeRequest();

        Target adapterTarget = new Adapter();
        adapterTarget.request();
    }
}
