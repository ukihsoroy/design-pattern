package org.ko.singleton;

import org.ko.singleton.byenum.EnumInstance;
import org.ko.singleton.lazy.demo1.LazySingleton2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 类加载时就已经创建好对象
 */
public class ReflectTest3 {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class objectClass = EnumInstance.class;

        Constructor constructor = objectClass.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);

        //反射对象
        EnumInstance newInstance = (EnumInstance) constructor.newInstance("K.O", 1);
        //实例对象
        EnumInstance instance = EnumInstance.getInstance();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);
    }
}
