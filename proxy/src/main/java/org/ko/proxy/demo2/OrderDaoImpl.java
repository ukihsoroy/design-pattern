package org.ko.proxy.demo2;

public class OrderDaoImpl implements IOrderDao {
    @Override
    public int insert(Order order) {
        System.out.println("Dao添加Order成功！");
        return 1;
    }
}
