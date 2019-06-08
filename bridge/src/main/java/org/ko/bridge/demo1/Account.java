package org.ko.bridge.demo1;

/**
 * 银行账号， 桥的实现接口
 */
public interface Account {
    /**
     * 打开账号
     * @return
     */
    Account openAccount();

    /**
     * 查看账号类型
     */
    void showAccountType();
}
