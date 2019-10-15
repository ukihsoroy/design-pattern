package org.ko.proxy.demo1.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 时间处理器
 * @author zhiyuan.shen
 */
public class TimeHandler implements InvocationHandler{

    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy 被代理的对象
     * @param method 被代理对象的方法
     * @param args 被代理方法的参数
     * @return 方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("car start...");
        method.invoke(target);
        System.out.println("car end...");
        long endTime = System.currentTimeMillis();
        System.out.println("used " + (endTime - startTime) + " ms！");
        return null;
    }

}
