package org.ko.command.demo1;

public class Test {

    public static void main(String[] args) {
        CourseVideo courseVideo = new CourseVideo("Java设计模式精讲");
        OpenCourseVideoCommand openCourseVideoCommand = new OpenCourseVideoCommand(courseVideo);
        CloseCourseVideoCommand closeCourseVideoCommand = new CloseCourseVideoCommand(courseVideo);

        Staff staff = new Staff();

        staff.addCommand(openCourseVideoCommand);
        staff.addCommand(closeCourseVideoCommand);

        staff.executeCommands();
    }
}
