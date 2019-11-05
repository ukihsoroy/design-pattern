package org.ko.memento.basic;

/**
 * 发起人类
 */
public class Originator {

    /**
     * 状态编码
     */
    private String status;

    public Originator(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 创建备忘录
     * @return
     */
    public Memento createMemento() {
        return new Memento(this);
    }

    /**
     * 回滚
     * @param memento
     */
    public void restoreMemento(Memento memento) {
        this.status = memento.getStatus();
    }
}
