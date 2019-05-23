package org.ko.design.principle.dependenceinversion;

public class PythonCourse implements ICourse {
    @Override
    public void studyCourse() {
        System.out.println("cos2a 在学习Python课程");
    }
}
