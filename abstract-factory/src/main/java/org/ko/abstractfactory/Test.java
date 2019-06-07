package org.ko.abstractfactory;

//测试与应用
public class Test {

    public static void main(String[] args) {
        //java 产品族
        ICourseFactory courseFactory = new JavaCourseFactory();
        Video video = courseFactory.getVideo();
        Article article = courseFactory.getArticle();
        video.produce();
        article.produce();
    }
}
