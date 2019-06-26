package org.ko.strategy.promotion2;

public class ManJianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("满减促销，满200 - 20元。");
    }
}
