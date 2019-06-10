package org.ko.proxy.demo2.dynamicproxy;


import org.ko.proxy.demo2.Order;
import org.ko.proxy.demo2.db.DataSourceContextHolder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class OrderServiceDynamicProxy implements InvocationHandler {

    private Object target;

    public OrderServiceDynamicProxy(Object target) {
        this.target = target;
    }

    public Object bind() {
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object argObject = args[0];
        beforeMethod(argObject);
        Object object = method.invoke(target, args);
        afterMethod();
        return object;
    }

    private void beforeMethod (Object obj) {
        int userId = 0;
        System.out.println("动态代理 before code!");

        if (obj instanceof Order) {
            Order order = (Order) obj;
            userId = order.getUserId();
            int dbRouter = userId % 2;

            System.out.println("动态代理分配到[db " + dbRouter + "] 处理数据");

            //todo 设置dataSource

            DataSourceContextHolder.setDBType("db" + dbRouter);
        }
    }

    private void afterMethod() {
        System.out.println("动态代理 after code!");
        DataSourceContextHolder.cleanDBType();
    }
}
