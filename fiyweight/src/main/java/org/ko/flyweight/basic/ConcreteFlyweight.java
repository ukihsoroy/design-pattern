package org.ko.flyweight.basic;

/**
 * 可以被共享的对象
 */
public class ConcreteFlyweight implements Flyweight{

    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println(this.intrinsicState + "---:" + extrinsicState);
    }
}
