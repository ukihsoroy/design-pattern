package org.ko.observer.d2;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 */
public class Teacher implements Observer {

    private String teacherName;

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public void update(Observable o, Object arg) {
        Course course = (Course) o;
        Question question = (Question) arg;

        System.out.println(teacherName + "老师的" + course.getCourseName()
                + "课程接收到一个" + question.getUsername()
                + "提出的" + question.getQuestionContent() + "问题");
    }
}
