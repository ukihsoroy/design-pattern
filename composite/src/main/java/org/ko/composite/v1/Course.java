package org.ko.composite.v1;

/**
 * 具体的课程
 */
public class Course extends CatalogComponent {

    private String name;

    private Double price;

    public Course(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println("> Course Name：" + this.name + ": price: " + this.price);
    }
}
