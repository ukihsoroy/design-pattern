package org.ko.visitor.basic;

/**
 * 被访问对象接口
 */
public interface Element {

    void accept(Visitor visitor);

    String operation();
}
