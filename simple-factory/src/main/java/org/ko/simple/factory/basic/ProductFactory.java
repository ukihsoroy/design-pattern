package org.ko.simple.factory.basic;

public class ProductFactory {
    public static IProduct createProduct(String name) {
        Product product = null;
        if ("product".equals(name)) {
            product = new Product();
        }
        return product;
    }
}
