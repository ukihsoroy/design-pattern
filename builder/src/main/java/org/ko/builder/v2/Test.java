package org.ko.builder.v2;

/**
 * 测试与应用
 */
public class Test {
    public static void main(String[] args) {
        Course course1 = new Course.CourseBuilder()
                .buildCourseName("Java课程精讲")
                .buildCourseArticle("Java课程精讲手机")
                .buildCoursePPT("Java课程精讲PPT")
                .buildCourseVideo("Java课程精讲视频")
                .build();

        System.out.println(course1.toString());

        Course course2 = new Course.CourseBuilder()
                .buildCourseName("Java课程精讲")
                .buildCourseVideo("Java课程精讲视频")
                .build();

        System.out.println(course2.toString());
    }
}
