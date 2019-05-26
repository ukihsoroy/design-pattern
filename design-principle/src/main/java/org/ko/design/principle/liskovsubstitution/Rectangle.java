package org.ko.design.principle.liskovsubstitution;

/**
 * 长方形
 */
public class Rectangle {

    private long length;

    private long width;

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }
}
