package org.ko.design.principle.compositionaggregation;

public class ProductDAO extends DBConnection {
    public void addProduct () {
        String conn = super.getConnection();
        System.out.println(conn + "增加产品");
    }
}
