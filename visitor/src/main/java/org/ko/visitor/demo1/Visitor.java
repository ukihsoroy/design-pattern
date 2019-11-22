package org.ko.visitor.demo1;

/**
 * 访问者的具体实现
 */
public class Visitor implements IVisitor {
    @Override
    public void visit(FreeCourse freeCourse) {
        System.out.println("free course: " + freeCourse.getName());
    }

    @Override
    public void visit(CodingCourse codingCourse) {
        System.out.println("coding course: " + codingCourse.getName() + " price: " + codingCourse.getPrice());
    }
}
