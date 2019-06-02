package org.ko.basic;

public class Test {
    public static void main(String[] args) {
        IFactory factory = new Factory();
        IProduct product = factory.createProduct();
        product.produce();
    }
}
