package org.ko.adapter.basic.objectadapter;

/**
 * 适配器模式
 */
public class Adapter implements Target {

    /**
     * 组合了被适配的类，这里可以通过set方式注入
     */
    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        //todo...
        System.out.println("适配后----");
        adaptee.adapteeRequest();
        //todo...
    }
}
