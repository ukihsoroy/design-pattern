package org.ko.template.method.demo1;

/**
 * 测试与应用类
 */
public class Test {

    public static void main(String[] args) {
        AnimalAbstract fish = new Fish();
        AnimalAbstract monkey = new Monkey();
        AnimalAbstract tiger = new Tiger();
        fish.life();
        monkey.life();
        tiger.life();
    }
}
