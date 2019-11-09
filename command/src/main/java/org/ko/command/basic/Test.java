package org.ko.command.basic;


/**
 * 应用与测试
 */
public class Test {

    public static void main(String[] args) {
        //创建命令接收方
        Receiver receiver = new Receiver();

        //创建执行者
        Invoker invoker = new Invoker();

        //创建命令
        ConcreteCommand1 concreteCommand1 = new ConcreteCommand1(receiver);
        ConcreteCommand2 concreteCommand2 = new ConcreteCommand2(receiver);

        //添加命令
        invoker.addCommand(concreteCommand1);
        invoker.addCommand(concreteCommand2);

        //执行
        invoker.executorCommands();
    }
}
