package org.ko.template.method.basic;

/**
 * 具体的实现类
 */
public class BusinessEntity extends ATemplate {

    @Override
    protected void before() {
        super.before();
        System.out.println("before");
    }

    @Override
    public void doAction() {
        System.out.println("doAction");
    }
}
