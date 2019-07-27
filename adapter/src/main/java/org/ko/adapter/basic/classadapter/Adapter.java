package org.ko.adapter.basic.classadapter;

/**
 * 适配器，继承了被适配的类，并且实现了Target定义的接口
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        //todo...
        System.out.println("适配后----");
        super.adapteeRequest();
        //todo...
    }
}
