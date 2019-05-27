package org.ko.factorymethod;

public class Test {

    public static void main(String[] args) {
        VideoFactory videoFactory = new JavaVideoFactory();
        Video video1 = videoFactory.getVideo();
        video1.produce();

        videoFactory = new PythonVideoFactory();
        Video video2 = videoFactory.getVideo();
        video2.produce();

        videoFactory = new FEVideoFactory();
        Video video3 = videoFactory.getVideo();
        video3.produce();
    }
}
