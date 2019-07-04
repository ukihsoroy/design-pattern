package org.ko.state.demo1;

public class PauseState extends CourseVideoState  {
    @Override
    public void play() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.PLAY_STATE);
    }

    @Override
    public void speed() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.SPEED_STATE);
    }

    @Override
    public void pause() {
        System.out.println("暂停播放视频");
    }

    @Override
    public void stop() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.STOP_STATE);
    }
}
