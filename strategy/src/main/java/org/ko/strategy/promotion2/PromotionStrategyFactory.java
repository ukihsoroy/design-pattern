package org.ko.strategy.promotion2;

import sun.dc.pr.PRError;

import java.util.HashMap;
import java.util.Map;

public class PromotionStrategyFactory {

    private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_CONTAINS = new HashMap<>();

    private static PromotionStrategy NON_PROMOTION = new EmptyPromotionStrategy();

    static {
        PROMOTION_STRATEGY_CONTAINS.put(PromotionKey.MANJIAN, new ManJianPromotionStrategy());
        PROMOTION_STRATEGY_CONTAINS.put(PromotionKey.FANXIAN, new FanXianPromotionStrategy());
        PROMOTION_STRATEGY_CONTAINS.put(PromotionKey.LIJIAN, new LiJianPromotionStrategy());
    }

    public static PromotionStrategy getPromotionStrategy (String key) {
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_CONTAINS.get(key);
        return promotionStrategy == null ? NON_PROMOTION : promotionStrategy;
    }

    private PromotionStrategyFactory() {}

    private interface PromotionKey {
        String LIJIAN = "LIJIAN";
        String FANXIAN = "FANXIAN";
        String MANJIAN = "MANJIAN";
    }
}
