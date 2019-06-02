package org.ko.factorymethod;

public class PythonVideoFactory extends VideoFactory {
    @Override
    public PythonVideo getVideo() {
        return new PythonVideo();
    }
}
