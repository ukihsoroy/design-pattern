package org.ko.singleton;

import org.ko.singleton.lazy.demo1.LazySingleton2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 类加载时就已经创建好对象
 */
public class ReflectTest2 {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class objectClass = LazySingleton2.class;

        Constructor constructor = objectClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        //先创建后反射没有问题
        LazySingleton2 instance = LazySingleton2.getInstance();
        LazySingleton2 newInstance = (LazySingleton2) constructor.newInstance();

        //先反射后创建就会出现问题
//        LazySingleton2 newInstance = (LazySingleton2) constructor.newInstance();
//        LazySingleton2 instance = LazySingleton2.getInstance();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);
    }
}
