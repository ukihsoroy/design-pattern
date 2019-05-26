package org.ko.design.principle.compositionaggregation.v2;

public class MySQLConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "MySQL数据库连接";
    }
}
