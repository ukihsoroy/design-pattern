package org.ko.design.principle.liskovsubstitution.methodinput;

import java.util.HashMap;
import java.util.Map;

public class Child extends Base {

//    @Override
//    public void method(HashMap map) {
//        System.out.println("子类被执行");
//    }

    public void method(Map map) {
        System.out.println("子类重载方法被执行");
    }
}
