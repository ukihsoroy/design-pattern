package org.ko.design.principle.demeter;

import java.util.List;

public class TeamLeader {
    public void checkNumberOfCourse (List<Course> courses) {
        System.out.println("在线课程的数量是：" + courses.size());
    }
}
