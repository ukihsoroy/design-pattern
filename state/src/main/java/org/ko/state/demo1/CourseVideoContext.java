package org.ko.state.demo1;

/**
 * 课程状态上下文
 */
public class CourseVideoContext {

    //当前状态
    private CourseVideoState courseVideoState;

    //播放
    public final static PlayState PLAY_STATE = new PlayState();

    //停止
    public final static StopState STOP_STATE = new StopState();

    //快进
    public final static SpeedState SPEED_STATE = new SpeedState();

    //暂停
    public final static PauseState PAUSE_STATE = new PauseState();

    public CourseVideoState getCourseVideoState() {
        return courseVideoState;
    }

    public void setCourseVideoState(CourseVideoState courseVideoState) {
        this.courseVideoState = courseVideoState;
        this.courseVideoState.setCourseVideoContext(this);
    }

    public void play() {
        this.courseVideoState.play();
    }

    public void speed() {
        this.courseVideoState.speed();
    }

    public void pause() {
        this.courseVideoState.pause();
    }

    public void stop() {
        this.courseVideoState.stop();
    }
}
