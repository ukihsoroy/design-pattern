package org.ko.visitor.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试与应用类
 */
public class Test {

    public static void main(String[] args) {
        //初始化被访问列表
        List<Element> elements = new ArrayList<>();

        //初始化访问者
        Visitor visitor = new ConcreteVisitor();

        //初始化元素
        Element element1 = new ConcreteElementA();
        Element element2 = new ConcreteElementB();

        //装填
        elements.add(element1);
        elements.add(element2);

        //访问
        elements.forEach(e -> e.accept(visitor));
    }

}
