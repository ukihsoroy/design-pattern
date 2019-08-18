package org.ko.bridge.demo1;

/**
 * 定期账户实现类
 */
public class DepositAccount implements Account {
    @Override
    public DepositAccount openAccount() {
        System.out.println("打开定期账号");
        return new DepositAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是定期账号");
    }
}
