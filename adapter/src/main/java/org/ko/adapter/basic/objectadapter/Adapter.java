package org.ko.adapter.basic.objectadapter;

public class Adapter implements Target {

    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        //todo...
        adaptee.adapteeRequest();
        //todo...
    }
}
