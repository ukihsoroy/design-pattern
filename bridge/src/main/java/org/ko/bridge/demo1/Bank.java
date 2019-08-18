package org.ko.bridge.demo1;

/**
 * 银行抽象类
 */
public abstract class Bank {

    protected Account account;

    public Bank(Account account) {
        this.account = account;
    }

    /**
     * 不限制方法名，但因为委派所以起的一样
     * 不要自己都实现了，要尽量把行为委托给组合的类
     * @return
     */
    abstract Account openAccount();
}
