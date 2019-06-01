package org.ko.singleton.threadlocal;

import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args) {

        //每个线程都有一个副本，线程中是不一样的
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Thread t1 = new Thread(() -> {
                ThreadLocalInstance instance = ThreadLocalInstance.getInstance();
                System.out.println(Thread.currentThread().getName() + " " + instance);
            });
            threads.add(t1);
        }
        threads.forEach(Thread::start);
        System.out.println("---");

        //主线程中，获取的对象是同一个
        for (int i = 0; i < 50; i++) {
            ThreadLocalInstance instance = ThreadLocalInstance.getInstance();
            System.out.println(Thread.currentThread().getName() + " " + instance);
        }

    }
}
