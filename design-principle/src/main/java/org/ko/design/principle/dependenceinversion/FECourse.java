package org.ko.design.principle.dependenceinversion;

public class FECourse implements ICourse {
    @Override
    public void studyCourse() {
        System.out.println("cos2a 在学习前端课程");
    }
}
