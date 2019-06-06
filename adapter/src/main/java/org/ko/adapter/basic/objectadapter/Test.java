package org.ko.adapter.basic.objectadapter;


public class Test {

    public static void main(String[] args) {
        Target target = new ConcreateTarget();
        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();
    }
}
