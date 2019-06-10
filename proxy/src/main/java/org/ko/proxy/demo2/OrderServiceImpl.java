package org.ko.proxy.demo2;

public class OrderServiceImpl implements IOrderService {

    //模仿spring注入，直接new了
    private IOrderDao orderDao = new OrderDaoImpl();

    @Override
    public int saveOrder(Order order) {
        System.out.println("Service调用Dao层添加Order!");
        return orderDao.insert(order);
    }
}
