package org.ko.builder.basic.abstractbuilder;

/**
 * 产品具体的构建类
 */
public class ProductActualBuilder extends AProductBuilder {

    private Product product = new Product();

    @Override
    void buildProperty(String property) {
        product.setProperty(property);
    }

    @Override
    Product makeProduct() {
        return product;
    }
}
