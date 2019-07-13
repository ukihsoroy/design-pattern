package org.ko.decorator.basic;

/**
 * 装饰器具体实现1
 */
public class Decorator1 extends ADecorator {
    public Decorator1(IComponent component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("decorator1");
    }
}
