package org.ko.singleton.lazy.demo1;

/**
 * 懒汉式
 * 线程不安全
 */
public class LazySingleton1 {

    private static LazySingleton1 lazySingleton1 = null;

    public static LazySingleton1 getInstance() {
        if (lazySingleton1 == null) {
            lazySingleton1 = new LazySingleton1();
        }
        return lazySingleton1;
    }
    private LazySingleton1() {}
}
