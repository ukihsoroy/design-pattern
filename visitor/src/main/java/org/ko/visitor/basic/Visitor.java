package org.ko.visitor.basic;

/**
 * 访问者接口
 */
public interface Visitor {

    /**
     * 访问A
     * @param element
     */
    void visit(ConcreteElementA element);

    /**
     * 访问B
     * @param element
     */
    void visit(ConcreteElementB element);

}
