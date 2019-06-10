package org.ko.proxy.demo2.db;

public class DataSourceContextHolder {

    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    public static void setDBType(String dbType) {
        CONTEXT_HOLDER.set(dbType);
    }

    public static String getDBType () {
        return CONTEXT_HOLDER.get();
    }

    public static void cleanDBType () {
        CONTEXT_HOLDER.remove();
    }
}
