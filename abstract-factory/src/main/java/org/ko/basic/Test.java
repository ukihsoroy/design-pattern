package org.ko.basic;

public class Test {

    public static void main(String[] args) {
        FactoryImpl factory = new FactoryImpl();
        ProductImpl1 productImpl1 = factory.createProduct1();
        ProductImpl2 productImpl2 = factory.createProduct2();

        productImpl1.produce();
        productImpl2.produce();
    }
}
