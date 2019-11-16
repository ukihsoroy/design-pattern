package org.ko.mediator.basic;

/**
 * 同事抽象类
 */
public abstract class Colleague {

    //中介者抽象类
    protected Mediator mediator;

    //接受消息
    public abstract void receive();

    //发送消息
    public abstract void send();

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
