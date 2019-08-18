package org.ko.bridge.basic;

/**
 * 实现类
 */
public class RefinedAbstraction extends Abstraction {

    public RefinedAbstraction (Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operation() {
        System.out.println("操作");
        implementor.operationImpl();
    }
}
