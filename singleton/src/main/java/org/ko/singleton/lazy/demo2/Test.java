package org.ko.singleton.lazy.demo2;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            threads.add(new Thread(() -> {
                StaticInnerClassSingleton staticInnerClassSingleton = StaticInnerClassSingleton.getInstance();
                System.out.println(Thread.currentThread().getName() + " " + staticInnerClassSingleton);
            }));
        }

        threads.forEach(Thread::start);
    }
}
