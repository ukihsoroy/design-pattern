package org.ko.decorator.brekker.v2;

/**
 * 煎饼的抽象类，也就是组建类
 */
public abstract class ABattercake {

    /**
     * 最后的描述
     * @return
     */
    protected abstract String getDesc ();

    /**
     * 总共的价格
     * @return
     */
        protected abstract int cost ();

}
