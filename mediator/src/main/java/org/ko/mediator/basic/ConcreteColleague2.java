package org.ko.mediator.basic;

/**
 * 具体的同事类2
 */
public class ConcreteColleague2 extends Colleague {
    @Override
    public void receive() {
        System.out.println("colleague2 receive message.");
    }

    @Override
    public void send() {
        System.out.println("colleague2 send message.");
        //请中介者转发
        this.mediator.relay(this);
    }
}
