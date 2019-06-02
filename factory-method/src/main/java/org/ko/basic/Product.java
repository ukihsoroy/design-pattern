package org.ko.basic;

public class Product implements IProduct{
    @Override
    public void produce() {
        System.out.println("具体产品业务。");
    }
}
