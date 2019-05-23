package org.ko.design.principle.dependenceinversion;

public class Cos2a {

    private ICourse course;

    public Cos2a(ICourse course) {
        this.course = course;
    }

    public void studyCourse () {
        course.studyCourse();
    }

    public void studyImoocCourse(ICourse course) {
        course.studyCourse();
    }

    public void setCourse(ICourse course) {
        this.course = course;
    }

    //    public void studyJavaCourse() {
//        System.out.println("cos2a 在学习Java课程");
//    }
//
//    public void studyFECourse () {
//        System.out.println("cos2a 在学习前端课程");
//    }
//
//    public void studyPythonCourse () {
//        System.out.println("cos2a 在学习Python");
//    }
}
