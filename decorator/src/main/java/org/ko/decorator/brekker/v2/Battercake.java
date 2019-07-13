package org.ko.decorator.brekker.v2;

/**
 * 煎饼的具体实现
 */
public class Battercake extends ABattercake {
    @Override
    protected String getDesc() {
        return "煎饼";
    }

    @Override
    protected int cost() {
        return 8;
    }
}
