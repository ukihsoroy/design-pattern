package org.ko.facade;


/**
 * 客户端与测试类
 */
public class Test {

    public static void main(String[] args) {
        PointsGift pointsGift = new PointsGift("连衣裙");
        GiftExchangeService giftExchangeService = new GiftExchangeService();

//        giftExchangeService.setQualifyService(new QualifyService());
//        giftExchangeService.setPointsPaymentService(new PointsPaymentService());
//        giftExchangeService.setShippingService(new ShippingService());

        giftExchangeService.giftExchange(pointsGift);
    }
}
