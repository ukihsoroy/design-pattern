package org.ko.visitor.basic;

/**
 * 具体的访问者
 */
public class ConcreteVisitor implements Visitor {
    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("visit: " + element.operation());
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("visit: " + element.operation());
    }
}
