package org.ko.decorator.basic;


/**
 * 装饰器的抽象类
 */
public abstract class ADecorator implements IComponent {
    /**
     * 关键在于这个组合组件接口对象
     */
    private IComponent component;

    public ADecorator(IComponent component) {
        this.component = component;
    }

    @Override
    public void operation () {
        component.operation();
    }
}
