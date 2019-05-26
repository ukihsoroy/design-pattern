package org.ko.design.principle.openclose;

public class JavaDiscountCourse extends JavaCourse {

    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    public Double getDiscountPrice() {
        return super.getPrice() * 0.8;
    }

//    @Override
//    public Double getDiscountPrice() {
//        return price * 0.8;
//    }
}
