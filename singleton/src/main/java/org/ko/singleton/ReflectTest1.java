package org.ko.singleton;

import org.ko.singleton.hungry.HungrySingleton2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 类加载时就已经创建好对象
 */
public class ReflectTest1 {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class objectClass = HungrySingleton2.class;

        Constructor constructor = objectClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        //反射创建
        HungrySingleton2 instance = HungrySingleton2.getInstance();

        //正常创建
        HungrySingleton2 newInstance = (HungrySingleton2) constructor.newInstance();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);

        //StaticInnerClassSingleton类也是一样的
    }
}
