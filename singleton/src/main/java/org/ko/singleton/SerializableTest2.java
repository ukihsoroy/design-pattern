package org.ko.singleton;

import org.ko.singleton.byenum.EnumInstance;

import java.io.*;

/**
 * 枚举类测试
 */
public class SerializableTest2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //测试枚举类型
        EnumInstance instance = EnumInstance.getInstance();
        //设置对象
        instance.setData(new Object());

        //写入文件
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
        oos.writeObject(instance);

        //读取文件
        File file = new File("singleton_file");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        EnumInstance newInstance = (EnumInstance) ois.readObject();

        //比较实例
        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);

        //比较实例中引用对象
        System.out.println(instance.getData());
        System.out.println(newInstance.getData());
        System.out.println(instance.getData() == newInstance.getData());
    }
}
