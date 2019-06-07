package org.ko.builder.basic.abstractbuilder;

public class Test {

    public static void main(String[] args) {
        Coach coach = new Coach();
        coach.setProductBuilder(new ProductActualBuilder());
        Product product = coach.createProduct("测试属性");
        System.out.println(product.getProperty());
    }
}
