package org.ko.prototype.clone;

import java.util.Date;

public class Test1 {

    public static void main(String[] args) throws CloneNotSupportedException {
        //浅克隆, 没办法克隆引用对象
        Date birthday = new Date(0l);

        Pig1 pig1 = new Pig1("佩奇", birthday);
        Pig1 pig12 = (Pig1) pig1.clone();

        System.out.println(pig1);
        System.out.println(pig12);
        System.out.println("-------");

        pig1.getBirthday().setTime(666666666666L);

        System.out.println(pig1);
        System.out.println(pig12);
    }
}
