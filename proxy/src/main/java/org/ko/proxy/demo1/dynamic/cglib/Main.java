package org.ko.proxy.demo1.dynamic.cglib;

/**
 * @author zhiyuan.shen
 */
public class Main {

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        Train train = (Train)proxy.getProxy(Train.class);
        train.move();
    }
}
