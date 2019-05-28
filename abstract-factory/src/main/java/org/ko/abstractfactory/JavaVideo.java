package org.ko.abstractfactory;

public class JavaVideo extends Video {

    @Override
    public void produce() {
        System.out.println("录制JAVA课程视频");
    }
}
