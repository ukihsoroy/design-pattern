package org.ko.mediator.basic;

/**
 * 中介者抽象类
 */
public abstract class Mediator {

    //注册同事
    abstract void register(Colleague colleague);

    //通知中介者，发送消息
    abstract void relay(Colleague colleague);

}
