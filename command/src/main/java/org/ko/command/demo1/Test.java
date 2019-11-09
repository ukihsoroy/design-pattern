package org.ko.command.demo1;

/**
 * 测试与应用
 */
public class Test {

    public static void main(String[] args) {
        //命令接收者
        CourseVideo courseVideo = new CourseVideo("Java设计模式精讲");

        //创建命令
        OpenCourseVideoCommand openCourseVideoCommand = new OpenCourseVideoCommand(courseVideo);
        CloseCourseVideoCommand closeCourseVideoCommand = new CloseCourseVideoCommand(courseVideo);

        //创建执行人
        Staff staff = new Staff();

        //添加命令
        staff.addCommand(openCourseVideoCommand);
        staff.addCommand(closeCourseVideoCommand);

        //执行
        staff.executeCommands();
    }
}
