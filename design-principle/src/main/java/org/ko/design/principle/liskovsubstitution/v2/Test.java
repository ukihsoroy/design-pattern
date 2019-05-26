package org.ko.design.principle.liskovsubstitution.v2;


public class Test {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setLength(20);
        resize(rectangle);
    }

//    //正发型和长方形不再有关系
//    public static void main(String[] args) {
//        Square square = new Square();
//        square.setLength(10);
//        //死循环，和预料的情况不一致
//        resize(square);
//    }

    private static void resize(Rectangle rectangle) {
        while (rectangle.getWidth() <= rectangle.getLength()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
            System.out.println("width: " + rectangle.getWidth() + "\n"
                    + "length: " + rectangle.getLength());
        }
        System.out.println("resize方法结束：width: " + rectangle.getWidth() + "\n"
                + "length: " + rectangle.getLength());
    }
}
