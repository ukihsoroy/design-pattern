package org.ko.decorator.basic;

/**
 * 具体组件类的具体业务逻辑实现
 */
public class Component implements IComponent {
    @Override
    public void operation() {
        System.out.println("component operation!");
    }
}
