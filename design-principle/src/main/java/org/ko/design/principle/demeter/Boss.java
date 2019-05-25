package org.ko.design.principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * TeamLeader是朋友
 * Course不是朋友
 */
public class Boss {

    public void commandCheckNumber (TeamLeader leader) {
        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            courses.add(new Course());
        }
        leader.checkNumberOfCourse(courses);
    }
}
