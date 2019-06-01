package org.ko.simple.factory;

public class Test {

//    public static void main(String[] args) {
//        Video video = new JavaVideo();
//        video.produce();
//    }

    public static void main(String[] args) {
        VideoFactory videoFactory = new VideoFactory();
        Video video1 = videoFactory.getVideo("python");
        if (video1 != null) {
            video1.produce();
        }
        Video video2 = videoFactory.getVideo("java");
        if (video2 != null) {
            video2.produce();
        }
    }

   /* public static void main(String[] args) {
        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo(PythonVideo.class);
        if (video != null) {
            video.produce();
        }
    }*/
}
