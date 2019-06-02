package org.ko.factorymethod;

public class FEVideoFactory extends VideoFactory {
    @Override
    public FEVideo getVideo() {
        return new FEVideo();
    }
}
