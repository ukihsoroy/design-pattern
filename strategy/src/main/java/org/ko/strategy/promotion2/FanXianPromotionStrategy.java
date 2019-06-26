package org.ko.strategy.promotion2;

public class FanXianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现20元到慕课网的余额中。");
    }
}
