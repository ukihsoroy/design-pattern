package org.ko.design.principle.compositionaggregation.v2;

public class ProductDAO {

    private DBConnection dbConnection;

    public void addProduct() {
        String conn = dbConnection.getConnection();
        System.out.println(conn + "，添加商品");
    }

    public DBConnection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }
}
