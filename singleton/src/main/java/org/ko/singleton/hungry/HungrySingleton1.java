package org.ko.singleton.hungry;

import java.io.Serializable;

/**
 * 饿汉式
 * 一开始就new好了
 */
public class HungrySingleton1 implements Serializable {

    /**
     * 可以直接new也可以适用静态块中创建
     * */
    private final static HungrySingleton1 hungrySingleton;

    static {
        hungrySingleton = new HungrySingleton1();
    }

    public static HungrySingleton1 getInstance() {
        return hungrySingleton;
    }

    /**
     * 私有构造函数
     */
    private HungrySingleton1() {}
}
