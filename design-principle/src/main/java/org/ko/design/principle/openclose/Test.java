package org.ko.design.principle.openclose;

public class Test {

    public static void main(String[] args) {
        ICourse javaCourse = new JavaCourse(96, "Java从零到企业级电商开发", 348d);
        System.out.println(
                "课程ID： " + javaCourse.getId() +
                "课程名字： " + javaCourse.getName() +
                "课程价钱：" + javaCourse.getPrice());

        ICourse javaDiscountCourse = new JavaDiscountCourse(96, "Java从零到企业级电商开发", 348d);
        JavaDiscountCourse j1 = (JavaDiscountCourse) javaDiscountCourse;
        System.out.println(
                "课程ID： " + j1.getId() +
                        "课程名字： " + j1.getName() +
                        "课程原价钱： " + j1.getPrice() +
                        "课程折后价钱：" + j1.getDiscountPrice());
    }
}
