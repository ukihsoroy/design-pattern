package org.ko.cor.basic;

/**
 * 实际责任链处理器1
 */
public class ConcreteHandler1 extends Handler {
    @Override
    public void handlerRequest(Integer count) {
        System.out.println("goto ConcreteHandler1");
        if (count <= 0) {
            System.out.println("ConcreteHandler1 process.");
        } else if (getSuccessor() != null) {
            getSuccessor().handlerRequest(count);
        }
    }
}
