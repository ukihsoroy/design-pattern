package org.ko.singleton.lazy.demo2;

public class StaticInnerClassSingleton {

    /**
     * 看静态类的初始化锁那个线程可以拿到
     */
    private static class InnerClass {
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return InnerClass.staticInnerClassSingleton;
    }

    private StaticInnerClassSingleton () {
        if (InnerClass.staticInnerClassSingleton != null) {
            throw new RuntimeException("单例对象禁止反射调用");
        }
    }
}
