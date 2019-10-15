package org.ko.proxy.basic.stati;

/**
 * 代理类
 * @author zhiyuan.shen
 */
public class Proxy implements Subject {

    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void doAction () {
        System.out.println("before");
        subject.doAction();
        System.out.println("after");
    }

}
