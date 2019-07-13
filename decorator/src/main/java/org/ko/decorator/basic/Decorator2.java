package org.ko.decorator.basic;

/**
 * 装饰器具体实现2
 */
public class Decorator2 extends ADecorator {

    public Decorator2(IComponent component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("decorator2");
    }
}
