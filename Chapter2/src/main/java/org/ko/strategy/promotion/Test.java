package org.ko.strategy.promotion;

import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {
        PromotionContext context = new PromotionContext();
        context.newPromotion(1);
        context.setPrice(new BigDecimal("200"));
        BigDecimal price = context.getPrice();
        System.out.println(price);

        context.newPromotion(2, new BigDecimal("0.8"));
        context.setPrice(new BigDecimal("200"));
        price = context.getPrice();
        System.out.println(price);

        context.newPromotion(3, new BigDecimal("300"), new BigDecimal("100"));
        context.setPrice(new BigDecimal("200"));
        price = context.getPrice();
        System.out.println(price);
        context.setPrice(new BigDecimal("300"));
        price = context.getPrice();
        System.out.println(price);

//        context.newInstance(4);
    }
}
