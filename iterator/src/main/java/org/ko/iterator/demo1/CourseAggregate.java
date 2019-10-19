package org.ko.iterator.demo1;

/**
 * 聚集类接口
 */
public interface CourseAggregate {

    void addCourse(Course course);

    void removeCourse(Course course);

    CourseIterator getCourseIterator();
}
