package org.ko.memento.basic;

/**
 * 备忘录类
 */
public class Memento {

    private String status;

    public Memento(Originator originator) {
        this.status = originator.getStatus();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
