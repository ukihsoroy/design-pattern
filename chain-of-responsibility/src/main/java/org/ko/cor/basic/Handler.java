package org.ko.cor.basic;

/**
 * 抽象处理类
 */
public abstract class Handler {

    //责任链下一个节点
    protected Handler successor;

    /**
     * 处理请求
     */
    public abstract void handlerRequest(Integer count);

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
