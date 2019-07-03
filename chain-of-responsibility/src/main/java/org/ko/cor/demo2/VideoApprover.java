package org.ko.cor.demo2;

public class VideoApprover extends Approver{


    @Override
    public void deploy(Course course) {
        if (course.getArticle() != null && course.getArticle().length() != 0) {
            System.out.println(course.getVideo() + "含有视频，批准。");
            if (approver != null) {
                approver.deploy(course);
            }
        } else {
            System.out.println(course.getVideo() + "不包含有视频，不批准。");
        }
    }
}
