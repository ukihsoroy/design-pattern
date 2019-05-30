package org.ko.singleton.lazy.demo1;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
//        LazySingleton1 lazySingleton = LazySingleton1.getInstance();
//        System.out.println("program end!");

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Thread t1 = new Thread(() -> {
                LazySingleton1 lazySingleton1 = LazySingleton1.getInstance();
                System.out.println(Thread.currentThread().getName() + " " + lazySingleton1);

                LazySingleton2 lazySingleton2 = LazySingleton2.getInstance();
                System.out.println(Thread.currentThread().getName() + " " + lazySingleton2);

                LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
                System.out.println(Thread.currentThread().getName() + " " + instance);
            });
            threads.add(t1);
        }
        threads.forEach(Thread::start);
        System.out.println("---");
    }
}
