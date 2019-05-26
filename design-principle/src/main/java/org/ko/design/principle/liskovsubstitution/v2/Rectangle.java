package org.ko.design.principle.liskovsubstitution.v2;

/**
 * 长方形
 */
public class Rectangle implements IQuadrangle {

    private long length;

    private long width;

    public void setLength(long length) {
        this.length = length;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    @Override
    public long getWidth() {
        return width;
    }

    @Override
    public long getLength() {
        return length;
    }
}
