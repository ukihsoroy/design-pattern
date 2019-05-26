package org.ko.design.principle.liskovsubstitution.methodoutput;

import java.util.HashMap;

public class Child extends Base {
    @Override
    public HashMap method() {
        System.out.println("子类method被执行");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("message", "子类消息");
        return hashMap;
    }
}
