package org.ko.simple.factory.basic;

public class Product implements IProduct{
    @Override
    public void produce() {
        System.out.println("产品逻辑");
    }
}
