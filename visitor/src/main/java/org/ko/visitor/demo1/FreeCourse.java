package org.ko.visitor.demo1;

public class FreeCourse extends Course {


    @Override
    void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
