package org.ko.factorymethod;

public class JavaVideoFactory extends VideoFactory {
    @Override
    public JavaVideo getVideo() {
        return new JavaVideo();
    }
}
