package org.ko.abstractfactory;

//Java课程工厂
public class JavaCourseFactory implements ICourseFactory {
    @Override
    public JavaVideo getVideo() {
        return new JavaVideo();
    }

    @Override
    public JavaArticle getArticle() {
        return new JavaArticle();
    }
}
