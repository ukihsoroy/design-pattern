package org.ko.visitor.demo1;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();

        FreeCourse freeCourse = new FreeCourse();
        freeCourse.setName("SpringMVC数据绑定。");

        CodingCourse codingCourse = new CodingCourse();
        codingCourse.setName("Java设计模式精讲");
        codingCourse.setPrice(299);

        courses.add(freeCourse);
        courses.add(codingCourse);

        for (Course course : courses) {
            course.accept(new Visitor());
        }
    }
}
