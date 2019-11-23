package org.ko.state.basic;

/**
 * 具体的状态
 */
public class ConcreteStateA implements State {
    @Override
    public void handler(Context context) {
        System.out.println("this is state A.");
        context.setState(new ConcreteStateB());
    }
}
