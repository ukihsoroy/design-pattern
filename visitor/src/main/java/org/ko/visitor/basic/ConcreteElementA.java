package org.ko.visitor.basic;

/**
 * 具体实例A
 */
public class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String operation() {
        return "ConcreteElementA";
    }
}
