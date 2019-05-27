package org.ko.factorymethod;

public class FEVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制前端视频");
    }
}
