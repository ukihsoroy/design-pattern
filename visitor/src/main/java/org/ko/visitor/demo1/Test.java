package org.ko.visitor.demo1;

import java.util.ArrayList;
import java.util.List;


/**
 * 测试与应用类
 */
public class Test {

    public static void main(String[] args) {
        //初始化容器
        List<Course> courses = new ArrayList<>();

        //构建课程实现
        FreeCourse freeCourse = new FreeCourse();
        freeCourse.setName("SpringMVC.");

        CodingCourse codingCourse = new CodingCourse();
        codingCourse.setName("Java design pattern.");
        codingCourse.setPrice(299);

        //装填
        courses.add(freeCourse);
        courses.add(codingCourse);

        //访问
        for (Course course : courses) {
            course.accept(new Visitor());
        }
    }
}
