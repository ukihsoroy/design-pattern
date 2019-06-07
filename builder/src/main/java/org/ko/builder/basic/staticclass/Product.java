package org.ko.builder.basic.staticclass;

/**
 * 产品类
 */
public class Product {


    /**
     * 产品属性，只是举了一个例子，可以有很多个
     */
    private String property;

    /**
     * 产品的构建 构造方法
     * @param productBuilder
     */
    public Product (ProductBuilder productBuilder) {
        this.property = productBuilder.property;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * 产品构建类
     */
    public static class ProductBuilder {

        private String property;

        public ProductBuilder builderProperty (String property) {
            this.property = property;
            return this;
        }

        public Product build() {
            return new Product(this);
        }

    }
}
