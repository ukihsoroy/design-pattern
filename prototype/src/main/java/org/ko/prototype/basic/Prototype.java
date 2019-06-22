package org.ko.prototype.basic;

import java.util.List;

/**
 * 原型模式
 */
public class Prototype implements Cloneable {

    private String name;

    private List<String> names;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
