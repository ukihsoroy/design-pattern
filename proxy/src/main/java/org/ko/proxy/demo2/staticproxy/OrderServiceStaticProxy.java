package org.ko.proxy.demo2.staticproxy;

import org.ko.proxy.demo2.IOrderService;
import org.ko.proxy.demo2.Order;
import org.ko.proxy.demo2.OrderServiceImpl;
import org.ko.proxy.demo2.db.DataSourceContextHolder;

public class OrderServiceStaticProxy {

    private IOrderService orderService = new OrderServiceImpl();

    public int saveOrder (Order order) {
        beforeMethod(order);

        int count = orderService.saveOrder(order);

        afterMethod();

        return count;
    }

    private void beforeMethod(Order order) {
        System.out.println("静态代理 before code!");
        int userId = order.getUserId();
        int dbRouter = userId % 2;

        System.out.println("静态代理分配到[db " + dbRouter + "] 处理数据");

        //todo 设置dataSource

        DataSourceContextHolder.setDBType("db" + dbRouter);
    }

    private void afterMethod() {
        System.out.println("静态代理 after code!");
        DataSourceContextHolder.cleanDBType();
    }
}
