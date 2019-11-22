package org.ko.visitor.demo1;

/**
 * 具体的实体类，免费课程
 */
public class FreeCourse extends Course {


    @Override
    void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
