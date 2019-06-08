package org.ko.singleton;

import org.ko.singleton.hungry.HungrySingleton2;

import java.io.*;

public class SerializableTest1 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HungrySingleton2 instance = HungrySingleton2.getInstance();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
        oos.writeObject(instance);

        File file = new File("singleton_file");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        HungrySingleton2 newInstance = (HungrySingleton2) ois.readObject();

        System.out.println(instance);
        System.out.println(newInstance);

        System.out.println(instance == newInstance);

    }
}
