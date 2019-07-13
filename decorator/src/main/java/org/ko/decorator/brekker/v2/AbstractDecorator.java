package org.ko.decorator.brekker.v2;

/**
 * 装饰着的抽象类
 */
public abstract class AbstractDecorator extends ABattercake {

    //组合的煎饼对象
    private ABattercake aBattercake;

    public AbstractDecorator(ABattercake aBattercake) {
        this.aBattercake = aBattercake;
    }

    protected abstract void doSomething();

    @Override
    protected String getDesc() {
        return aBattercake.getDesc();
    }

    @Override
    protected int cost() {
        return aBattercake.cost();
    }
}
