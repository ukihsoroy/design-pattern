package org.ko.design.principle.dependenceinversion;

public class Test {

    //v1
//    public static void main(String[] args) {
//        Cos2a cos2a = new Cos2a();
//        cos2a.studyFECourse();
//        cos2a.studyJavaCourse();
//        cos2a.studyPythonCourse();
//    }

    //v2
//    public static void main(String[] args) {
//        Cos2a cos2a = new Cos2a();
//        cos2a.studyImoocCourse(new JavaCourse());
//        cos2a.studyImoocCourse(new FECourse());
//        cos2a.studyImoocCourse(new PythonCourse());
//    }

    //v3
    public static void main(String[] args) {
        Cos2a cos2a = new Cos2a(new JavaCourse());
        cos2a.studyCourse();

        cos2a.setCourse(new FECourse());
        cos2a.studyCourse();

        cos2a.setCourse(new PythonCourse());
        cos2a.studyCourse();
    }
}
