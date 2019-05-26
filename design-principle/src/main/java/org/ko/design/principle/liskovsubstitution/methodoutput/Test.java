package org.ko.design.principle.liskovsubstitution.methodoutput;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        Child child = new Child();
        HashMap map = child.method();
        map.forEach((k, v) -> System.out.println(k + ":" + "v"));
    }
}
