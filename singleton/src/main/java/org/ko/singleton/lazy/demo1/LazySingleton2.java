package org.ko.singleton.lazy.demo1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 懒汉式
 * 线程不安全
 */
public class LazySingleton2 {

    private static LazySingleton2 lazySingleton1 = null;

    private static boolean flag = true;

    /**
     * 在静态方法中直接加synchronized相当于锁了类
     * @return
     */
    public synchronized static LazySingleton2 getInstance() {
        //同样实锁类
//        synchronized (LazySingleton2.class) {
            if (lazySingleton1 == null) {
                lazySingleton1 = new LazySingleton2();
            }
//        }
        return lazySingleton1;
    }

    private LazySingleton2() {
        if (flag) {
            flag = false;
        } else {
            throw new RuntimeException("单例模式不可以再创建实例");
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class objectClass = LazySingleton2.class;
        Constructor constructor = objectClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        LazySingleton2 newInstance = (LazySingleton2) constructor.newInstance();

        Field flag = newInstance.getClass().getDeclaredField("flag");
        flag.setAccessible(true);
        flag.set(newInstance, true);

        LazySingleton2 instance = LazySingleton2.getInstance();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);
    }
}
