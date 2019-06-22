package org.ko.prototype.singleton;


/**
 * 简单的饿汉式单例
 */
public class StaticInnerClassSingleton1 implements Cloneable {

    /**
     * 看静态类的初始化锁那个线程可以拿到
     */
    private static class InnerClass {
        private static StaticInnerClassSingleton1 staticInnerClassSingleton = new StaticInnerClassSingleton1();
    }

    public static StaticInnerClassSingleton1 getInstance() {
        return InnerClass.staticInnerClassSingleton;
    }

    private StaticInnerClassSingleton1() {
        if (InnerClass.staticInnerClassSingleton != null) {
            throw new RuntimeException("单例对象禁止反射调用");
        }
    }

    /**
     * 修改克隆方法，返回单例对象
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return InnerClass.staticInnerClassSingleton;
    }
}
