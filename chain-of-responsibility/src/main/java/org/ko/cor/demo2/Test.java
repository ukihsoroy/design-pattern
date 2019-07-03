package org.ko.cor.demo2;

public class Test {

    public static void main(String[] args) {
        Approver articleApprover = new ArticleApprover();
        Approver videoApprover = new VideoApprover();

        Course course = new Course();
        course.setName("Java设计模式精讲");
        course.setArticle("Java设计模式精讲手记");
        course.setVideo("Java设计模式精讲视频");

        articleApprover.setNextApprover(videoApprover);
        articleApprover.deploy(course);
    }
}
