package org.ko.mediator.demo1;

public class Test {

    public static void main(String[] args) {
        User ko = new User("K.O");
        User tom = new User("Tom");
        ko.sendMessage("一起学习设计模式吧。");
        tom.sendMessage("好的");
    }
}
