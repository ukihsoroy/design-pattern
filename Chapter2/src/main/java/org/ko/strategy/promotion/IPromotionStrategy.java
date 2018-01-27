package org.ko.strategy.promotion;

import java.math.BigDecimal;

/**
 * 促销策略类
 */
public interface IPromotionStrategy {

    BigDecimal promotionAlgorithm();

    void setPrice(BigDecimal price);
}
