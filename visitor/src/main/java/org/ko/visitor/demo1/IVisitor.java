package org.ko.visitor.demo1;

/**
 * 访问者接口
 */
public interface IVisitor {

    void visit(FreeCourse freeCourse);

    void visit(CodingCourse codingCourse);
}
