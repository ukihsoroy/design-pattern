package org.ko.builder.basic.staticclass;

/**
 * 测试类
 */
public class Test {

    public static void main(String[] args) {
        Product product = new Product.ProductBuilder().builderProperty("测试属性").build();
        String p = product.getProperty();
        System.out.println(p);
    }
}
