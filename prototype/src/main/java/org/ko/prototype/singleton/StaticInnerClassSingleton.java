package org.ko.prototype.singleton;


/**
 * 简单的饿汉式单例
 */
public class StaticInnerClassSingleton implements Cloneable {

    /**
     * 看静态类的初始化锁那个线程可以拿到
     */
    private static class InnerClass {
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return InnerClass.staticInnerClassSingleton;
    }

    private StaticInnerClassSingleton() {
        if (InnerClass.staticInnerClassSingleton != null) {
            throw new RuntimeException("单例对象禁止反射调用");
        }
    }

    /**
     * 直接重写clone方法
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
