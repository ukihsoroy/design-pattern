package org.ko.prototype.clone;

import java.util.Date;

/**
 * 深克隆
 */
public class Pig2 implements Cloneable {
    private String name;

    private Date birthday;

    public Pig2(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Pig2 pig2 = (Pig2) super.clone();

        //深克隆, 要自己去做对象引用的克隆
        pig2.birthday = (Date) pig2.birthday.clone();
        return pig2;
    }

    @Override
    public String toString() {
        return "Pig2{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}' + super.toString();
    }
}
