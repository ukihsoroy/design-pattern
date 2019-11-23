package org.ko.state.demo1;

/**
 * 测试与应用
 */
public class Test {

    public static void main(String[] args) {
        //状态上下文
        CourseVideoContext courseVideoContext = new CourseVideoContext();

        //状态
        courseVideoContext.setCourseVideoState(new PlayState());
        System.out.println("当前状态：" + courseVideoContext.getCourseVideoState().getClass().getSimpleName());

        courseVideoContext.pause();
        System.out.println("当前状态：" + courseVideoContext.getCourseVideoState().getClass().getSimpleName());

        courseVideoContext.speed();
        System.out.println("当前状态：" + courseVideoContext.getCourseVideoState().getClass().getSimpleName());

        courseVideoContext.stop();
        System.out.println("当前状态：" + courseVideoContext.getCourseVideoState().getClass().getSimpleName());

        courseVideoContext.speed();

    }
}
