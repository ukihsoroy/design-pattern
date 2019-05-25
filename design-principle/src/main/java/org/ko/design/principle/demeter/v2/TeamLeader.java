package org.ko.design.principle.demeter.v2;

import org.ko.design.principle.demeter.Course;

import java.util.ArrayList;
import java.util.List;

public class TeamLeader {
    public void checkNumberOfCourse () {
        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            courses.add(new Course());
        }
        System.out.println("在线课程的数量是：" + courses.size());
    }
}
