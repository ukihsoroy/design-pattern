package org.ko.composite.v1;

/**
 * 测试与应用
 */
public class Test {

    public static void main(String[] args) {
        CatalogComponent linuxCourse = new Course("Linux课程", 11D);
        CatalogComponent windowCourse = new Course("Window课程", 12D);

        CatalogComponent javaCourseCatalog = new CourseCatalog("Java课程目录", 2);

        CatalogComponent mmallCourse1 = new Course("Java电商一期", 55D);
        CatalogComponent mmallCourse2 = new Course("Java电商二期", 66D);
        CatalogComponent designPattern = new Course("Java设计模式", 77D);

        javaCourseCatalog.add(mmallCourse1);
        javaCourseCatalog.add(mmallCourse2);
        javaCourseCatalog.add(designPattern);

        CatalogComponent mainCourseCatalog = new CourseCatalog("课程主目录", 1);

        mainCourseCatalog.add(linuxCourse);
        mainCourseCatalog.add(windowCourse);
        mainCourseCatalog.add(javaCourseCatalog);

        mainCourseCatalog.print();
    }
}
