package org.ko.bridge.basic;

/**
 * 主类抽象类
 */
public abstract class Abstraction {

    /**
     * 桥接组合对象
     */
    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    /**
     * 操作类
     */
    public abstract void operation();
}
