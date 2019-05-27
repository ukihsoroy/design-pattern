package org.ko.factorymethod;

public class FEVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new FEVideo();
    }
}
