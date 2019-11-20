package org.ko.cor.basic;

/**
 * 测试与应用
 */
public class Test {

    public static void main(String[] args) {
        //创建责任链
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();

        //组装
        handler1.setSuccessor(handler2);

        //处理
        handler1.handlerRequest(1);
    }
}
