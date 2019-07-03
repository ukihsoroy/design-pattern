package org.ko.cor.demo2;

public class ArticleApprover extends Approver{


    @Override
    public void deploy(Course course) {
        if (course.getArticle() != null && course.getArticle().length() != 0) {
            System.out.println(course.getArticle() + "含有手记，批准。");
            if (approver != null) {
                approver.deploy(course);
            }
        } else {
            System.out.println(course.getArticle() + "不包含有手记，不批准。");
        }
    }
}
