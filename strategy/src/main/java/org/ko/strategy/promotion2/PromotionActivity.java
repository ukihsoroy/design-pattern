package org.ko.strategy.promotion2;

public class PromotionActivity {

    private PromotionStrategy promotionStrategy;

    public PromotionActivity (PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void executorPromotionStrategy () {
        promotionStrategy.doPromotion();
    }
}
