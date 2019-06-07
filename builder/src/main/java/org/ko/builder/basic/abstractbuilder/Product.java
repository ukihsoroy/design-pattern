package org.ko.builder.basic.abstractbuilder;

/**
 * 产品类
 */
public class Product {

    /**
     * 产品实现细节，可以很多个属性，这里只mock了一个
     */
    private String property;

    public void setProperty(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }
}
