package org.ko.design.principle.compositionaggregation.v2;

public class Test {

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

        productDAO.setDbConnection(new PostgreSQLConnection());
        productDAO.addProduct();

        productDAO.setDbConnection(new MySQLConnection());
        productDAO.addProduct();
    }
}
