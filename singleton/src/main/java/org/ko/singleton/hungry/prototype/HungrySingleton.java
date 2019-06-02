package org.ko.singleton.hungry.prototype;

import java.io.Serializable;

/**
 * 饿汉式
 * 一开始就new好了
 */
public class HungrySingleton implements Serializable, Cloneable {

    private final static HungrySingleton hungrySingleton;

    static {
        hungrySingleton = new HungrySingleton();
    }

    public static HungrySingleton getInstance() {
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

    private HungrySingleton() {
        /**
         * 对一开始就创建好了的类有效
         */
        if (hungrySingleton != null) {
            throw new RuntimeException("单例对象禁止反射调用");
        }
    }

    /**
     * 防止克隆破坏，不实现Cloneable接口
     * 或者 clone() 直接返回getInstance()
     * @return
     * @throws CloneNotSupportedException
     */
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    @Override
    protected Object clone() {
        return getInstance();
    }
}
