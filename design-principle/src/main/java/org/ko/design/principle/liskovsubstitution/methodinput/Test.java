package org.ko.design.principle.liskovsubstitution.methodinput;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        //1. 重写加重载， 输出子类被执行
//        Child child = new Child();
//        HashMap map = new HashMap();
//        child.method(map);


        //2.注释掉重载方法，输出父类被执行
        Child child = new Child();
        HashMap map = new HashMap();
        child.method(map);
    }
}
