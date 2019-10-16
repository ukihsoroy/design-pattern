package org.ko.template.method.basic;

/**
 * 模板方法类
 */
public abstract class ATemplate {


    /**
     * 模板方法
     */
    public void templateMethod() {
        before();
        doAction();
        after();
    }

    /**
     * 钩子函数
     * 一个空的方法
     */
    protected void before(){}

    /**
     * 抽象方法
     * 业务逻辑
     */
    public abstract void doAction();

    /**
     * 具体方法
     */
    private void after() {
        System.out.println("after!");
    }
}
