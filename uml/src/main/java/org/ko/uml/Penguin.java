package org.ko.uml;

/**
 * 企鹅
 */
public class Penguin extends Bird {

    //气候
    public Climate climate;

    public Climate getClimate() {
        return climate;
    }

    public void setClimate(Climate climate) {
        this.climate = climate;
    }
}
