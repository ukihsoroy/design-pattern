package org.ko.singleton.hungry;

import java.io.Serializable;

/**
 * 饿汉式
 * 一开始就new好了
 */
public class HungrySingleton2 implements Serializable {

    private final static HungrySingleton2 hungrySingleton;

    static {
        hungrySingleton = new HungrySingleton2();
    }

    public static HungrySingleton2 getInstance() {
        return hungrySingleton;
    }

    /**
     * 写完后，序列化对象会通过反射调用这个方法
     * 完全是ObjectInputStream写死的，并没有任何继承关系
     * 其实每次序列化 反序列化 都已经创建对象了，只是最后返回的这一个
     * @return
     */
    private Object readResolve () {
        return hungrySingleton;
    }

    private HungrySingleton2() {
        /**
         * 对一开始就创建好了的类有效
         */
        if (hungrySingleton != null) {
            throw new RuntimeException("单例对象禁止反射调用");
        }
    }
}
