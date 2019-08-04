package org.ko.flyweight.basic;

/**
 * 不被共享的对象
 */
public class UnsharedConcreteFlyweight implements Flyweight {

    private String allState;

    public UnsharedConcreteFlyweight(String allState) {
        this.allState = allState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println(this.allState + "---:" + extrinsicState);
    }
}
