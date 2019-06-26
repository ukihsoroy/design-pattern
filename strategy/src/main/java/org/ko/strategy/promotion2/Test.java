package org.ko.strategy.promotion2;

public class Test {

    public static void main(String[] args) {
        PromotionActivity promotionActivity618 = new PromotionActivity(new LiJianPromotionStrategy());
        PromotionActivity promotionActivity1111 = new PromotionActivity(new FanXianPromotionStrategy());

        promotionActivity618.executorPromotionStrategy();
        promotionActivity1111.executorPromotionStrategy();
    }

//    public static void main(String[] args) {
//        PromotionActivity promotionActivity = null;
//
//        String promotionKey = "LIJIAN";
//
//        if (promotionKey.equalsIgnoreCase("LIJIAN")) {
//            promotionActivity = new PromotionActivity(new LiJianPromotionStrategy());
//        } else if (promotionKey.equals("MANJIAN")) {
//            promotionActivity = new PromotionActivity(new ManJianPromotionStrategy());
//        }
//
//        promotionActivity.executorPromotionStrategy();
//    }

//    public static void main(String[] args) {
//        String promotionKey = "LIJIAN";
//        PromotionStrategy promotionStrategy = PromotionStrategyFactory.getPromotionStrategy(promotionKey);
//        promotionStrategy.doPromotion();
//    }

}
