package org.ko.mediator.demo1;

/**
 * 测试与应用
 */
public class Test {

    public static void main(String[] args) {
        User ko = new User("K.O");
        User tom = new User("Tom");
        ko.sendMessage("learn design pattern.");
        tom.sendMessage("ok!");
    }
}
