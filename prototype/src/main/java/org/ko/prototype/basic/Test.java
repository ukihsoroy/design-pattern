package org.ko.prototype.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试与应用类
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new Prototype();
        prototype.setName("K.O");
        List<String> names = new ArrayList<>();
        names.add("K.O");
        prototype.setNames(names);
        for (int i = 0; i < 5; i ++) {
            Prototype p = (Prototype) prototype.clone();
            p.setName("sigma");
            p.getNames().add("sigma");
            System.out.println(p.toString());
            System.out.println(p.getName());
            System.out.println(p.getNames().size());

        }
        System.out.println(prototype.toString());
        System.out.println(prototype.getName());
        System.out.println(prototype.getNames().size());
    }
}
