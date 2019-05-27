package org.ko.factorymethod;

public class Test {

//    public static void main(String[] args) {
//        Video video = new JavaVideo();
//        video.produce();
//    }

//    public static void main(String[] args) {
//        VideoFactory videoFactory = new VideoFactory();
//        Video video = videoFactory.getVideo("python");
//        if (video != null) {
//            video.produce();
//        }
//    }

    public static void main(String[] args) {
        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo(PythonVideo.class);
        if (video != null) {
            video.produce();
        }
    }
}
