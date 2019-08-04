package org.ko.flyweight.basic;

import java.util.stream.Stream;

/**
 * 应用与测试
 */
public class Test {

    public static void main(String[] args) {

        Stream.of("1", "1", "2", "2", "3").forEach(key -> {
            Flyweight flyweight = FlyweightFactory.getFlyweight(key);
            flyweight.operation("测试" + key);
        });

        System.out.println("size: " + FlyweightFactory.size());
    }
}
