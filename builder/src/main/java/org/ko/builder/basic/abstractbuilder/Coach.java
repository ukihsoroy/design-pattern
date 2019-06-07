package org.ko.builder.basic.abstractbuilder;

/**
 * 教练类，封装了具体构建的细节
 */
public class Coach {

    private AProductBuilder productBuilder;

    public void setProductBuilder(AProductBuilder productBuilder) {
        this.productBuilder = productBuilder;
    }

    public Product createProduct(String property) {
        productBuilder.buildProperty(property);
        return this.productBuilder.makeProduct();
    }
}
