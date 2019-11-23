package org.ko.state.basic;

/**
 * 测试与应用
 */
public class Test {

    public static void main(String[] args) {
        //创建状态上下文
        Context context = new Context(new ConcreteStateA());

        //切换状态, 这个有点类似电灯的开关状态
        context.request();
        context.request();
        context.request();
        context.request();
        context.request();
    }
}
