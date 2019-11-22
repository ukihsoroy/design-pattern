package org.ko.visitor.basic;

/**
 * 具体实例B
 */
public class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String operation() {
        return "ConcreteElementB";
    }
}
