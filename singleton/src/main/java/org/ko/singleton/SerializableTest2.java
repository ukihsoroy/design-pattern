package org.ko.singleton;

import org.ko.singleton.byenum.EnumInstance;

import java.io.*;

public class SerializableTest2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //测试枚举类型
        EnumInstance instance = EnumInstance.getInstance();
        instance.setData(new Object());

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
        oos.writeObject(instance);

        File file = new File("singleton_file");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        EnumInstance newInstance = (EnumInstance) ois.readObject();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);

        System.out.println(instance.getData());
        System.out.println(newInstance.getData());
        System.out.println(instance.getData() == newInstance.getData());
    }
}
