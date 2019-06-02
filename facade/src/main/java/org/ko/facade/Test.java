package org.ko.facade;

public class Test {

    public static void main(String[] args) {
        PointsGift pointsGift = new PointsGift("连衣裙");
        GiftExchangeService giftExchangeService = new GiftExchangeService();

//        giftExchangeService.setQualifyService(new QualifyService());
//        giftExchangeService.setPointsPaymentService(new PointsPaymentService());
//        giftExchangeService.setShippingService(new ShippingService());

        giftExchangeService.giftExchane(pointsGift);
    }
}
