package org.ko.bridge.demo1;

/**
 * 活期账户实现类
 */
public class SavingAccount implements Account {
    @Override
    public SavingAccount openAccount() {
        System.out.println("打开活期账号");
        return new SavingAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是活期账号");
    }
}
