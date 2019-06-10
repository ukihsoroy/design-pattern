package org.ko.proxy.demo2.staticproxy;

import org.ko.proxy.demo2.Order;

public class Test {

    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(1);

        OrderServiceStaticProxy proxy = new OrderServiceStaticProxy();
        proxy.saveOrder(order);
    }
}
