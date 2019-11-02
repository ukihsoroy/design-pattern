package org.ko.observer.d2;

import java.util.Observable;

/**
 * 被观察对象实体
 */
public class Course extends Observable {

    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void produceQuestion(Course course, Question question) {
        System.out.println(question.getUsername() + "在" + course.getCourseName() + "提交了一个问题。");
        setChanged();
        notifyObservers(question);
    }
}
