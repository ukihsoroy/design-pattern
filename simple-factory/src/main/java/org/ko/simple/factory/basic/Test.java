package org.ko.simple.factory.basic;

public class Test {

    public static void main(String[] args) {
        IProduct product = ProductFactory.createProduct("product");
        product.produce();
    }
}
