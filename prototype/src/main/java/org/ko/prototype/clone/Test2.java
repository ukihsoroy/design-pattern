package org.ko.prototype.clone;

import java.util.Date;

public class Test2 {

    public static void main(String[] args) throws CloneNotSupportedException {
        //浅克隆, 没办法克隆引用对象
        Date birthday = new Date(0l);

        Pig2 p1 = new Pig2("佩奇", birthday);
        Pig2 p2 = (Pig2) p1.clone();

        System.out.println(p1);
        System.out.println(p2);
        System.out.println("-------");

        p1.getBirthday().setTime(666666666666L);

        System.out.println(p1);
        System.out.println(p2);
    }
}
