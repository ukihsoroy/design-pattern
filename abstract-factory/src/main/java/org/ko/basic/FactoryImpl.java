package org.ko.basic;

/**
 * 工厂实现
 */
public class FactoryImpl implements IFactory {
    @Override
    public ProductImpl1 createProduct1() {
        return new ProductImpl1();
    }

    @Override
    public ProductImpl2 createProduct2() {
        return new ProductImpl2();
    }
}
