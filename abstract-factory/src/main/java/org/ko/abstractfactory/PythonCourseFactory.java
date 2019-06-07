package org.ko.abstractfactory;

//Python课程工厂
public class PythonCourseFactory implements ICourseFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }

    @Override
    public Article getArticle() {
        return new PythonArticle();
    }
}
