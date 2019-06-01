package org.ko.singleton.container;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        ContainerSingleton.putInstance("object", new Object());
        for (int i = 0; i < 50; i++) {
            Thread t1 = new Thread(() -> {
                Object object = ContainerSingleton.getInstance("object");
                System.out.println(Thread.currentThread().getName() + " " + object);
            });
            threads.add(t1);
        }
        threads.forEach(Thread::start);
        System.out.println("---");
    }
}
