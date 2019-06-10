package org.ko.proxy.demo2.dynamicproxy;

import org.ko.proxy.demo2.IOrderService;
import org.ko.proxy.demo2.Order;
import org.ko.proxy.demo2.OrderServiceImpl;

public class Test {

    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(1);

        IOrderService proxy = (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();
        proxy.saveOrder(order);
    }
}
