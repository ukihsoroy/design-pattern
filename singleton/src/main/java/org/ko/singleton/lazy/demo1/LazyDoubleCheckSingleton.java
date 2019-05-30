package org.ko.singleton.lazy.demo1;

/**
 * 懒汉式
 * 线程不安全
 */
public class LazyDoubleCheckSingleton {

    //volatile 禁止指令重排序
    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;

    /**
     * 在静态方法中直接加synchronized相当于锁了类
     * @return
     */
    public static LazyDoubleCheckSingleton getInstance() {
        //同样实锁类, 指令重排序
        if (lazyDoubleCheckSingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazyDoubleCheckSingleton == null) {
                    /**
                     * 1.分配内存给这个对象
                     * 2.初始化对象
                     * 3.设置lazyDoubleCheckSingleton指向刚分配的内存
                     * 2 3 顺序有可能发生颠倒
                     * intra-thread semantics 不会改变单线程执行结果，指令重排序
                     */
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }



    private LazyDoubleCheckSingleton() {}
}
