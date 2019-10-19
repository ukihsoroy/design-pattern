package org.ko.iterator.demo1;

import java.util.List;

/**
 * 具体的迭代器
 */
public class CourseIteratorImpl implements CourseIterator {

    private List<Course> courseList;

    private int position;

    private Course course;


    public CourseIteratorImpl(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public Course nextCourse() {
        System.out.println("返回的课程，位置是： " + position);
        course = courseList.get(position);
        position ++;
        return course;
    }

    @Override
    public boolean hasNextCourse() {
        return position < courseList.size();
    }
}
