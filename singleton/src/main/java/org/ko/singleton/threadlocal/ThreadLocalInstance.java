package org.ko.singleton.threadlocal;

/**
 * 线程级单例模式
 */
public class ThreadLocalInstance {

    private static final ThreadLocal<ThreadLocalInstance> threadLocal =
            ThreadLocal.withInitial(ThreadLocalInstance::new);

    private ThreadLocalInstance () {}

    public static ThreadLocalInstance getInstance () {
        return threadLocal.get();
    }
}
