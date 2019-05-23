package org.ko.design.principle.openclose;

public interface ICourse {

    Integer getId();

    String getName();

    Double getPrice();

    /**
     * 不应该改变接口
     * @return
     */
//    Double getDiscountPrice();
}
