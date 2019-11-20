package org.ko.cor.basic;

/**
 * 实际责任链处理器2
 */
public class ConcreteHandler2 extends Handler {
    @Override
    public void handlerRequest(Integer count) {
        System.out.println("goto ConcreteHandler2");
        if (count > 0) {
            System.out.println("ConcreteHandler2 process.");
        } else if (getSuccessor() != null) {
            getSuccessor().handlerRequest(count);
        }
    }
}
