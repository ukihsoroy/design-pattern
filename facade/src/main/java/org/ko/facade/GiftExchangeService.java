package org.ko.facade;

/**
 * 扣减积分门面类
 */
public class GiftExchangeService {

    /**
     * 模拟注入
     */
    private QualifyService qualifyService = new QualifyService();
    private PointsPaymentService pointsPaymentService = new PointsPaymentService();
    private ShippingService shippingService = new ShippingService();

    //模拟注入，一开始就已经有了三个依赖的子系统
//    public void setQualifyService(QualifyService qualifyService) {
//        this.qualifyService = qualifyService;
//    }
//
//    public void setPointsPaymentService(PointsPaymentService pointsPaymentService) {
//        this.pointsPaymentService = pointsPaymentService;
//    }
//
//    public void setShippingService(ShippingService shippingService) {
//        this.shippingService = shippingService;
//    }

    public void giftExchange (PointsGift pointsGift) {
        if (qualifyService.isAvailable(pointsGift)) {
            //资格校验通过
            if (pointsPaymentService.pay(pointsGift)) {
                //如果支付积分成功
                String shippingOrderNo = shippingService.shipGift(pointsGift);
                System.out.println("物流订单号：" + shippingOrderNo);
            }
        }
    }
}
