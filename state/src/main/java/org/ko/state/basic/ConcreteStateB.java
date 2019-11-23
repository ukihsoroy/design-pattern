package org.ko.state.basic;

/**
 * 具体的状态
 */
public class ConcreteStateB implements State {
    @Override
    public void handler(Context context) {
        System.out.println("this is state B.");
        context.setState(new ConcreteStateA());
    }
}
