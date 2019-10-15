package org.ko.proxy.demo1.statics;

import java.util.Random;

/**
 * 具体的实现类
 * @author zhiyuan.shen
 */
public class Car implements MoveAble {

    /**
     * 实现开车
     */
    @Override
    public void move() {
        try {
            System.out.println("car moving.");
            Thread.sleep(new Random().nextInt(1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
