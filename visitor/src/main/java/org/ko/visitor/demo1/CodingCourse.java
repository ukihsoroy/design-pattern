package org.ko.visitor.demo1;

public class CodingCourse extends Course {

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
