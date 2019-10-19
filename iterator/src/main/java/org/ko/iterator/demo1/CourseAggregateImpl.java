package org.ko.iterator.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的聚集类
 */
public class CourseAggregateImpl implements CourseAggregate {


    private List<Course> courseList;

    public CourseAggregateImpl () {
        courseList = new ArrayList<>();
    }

    @Override
    public void addCourse(Course course) {
        courseList.add(course);
    }

    @Override
    public void removeCourse(Course course) {
        courseList.remove(course);
    }

    @Override
    public CourseIterator getCourseIterator() {
        return new CourseIteratorImpl(courseList);
    }
}
