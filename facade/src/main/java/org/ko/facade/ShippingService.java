package org.ko.facade;

public class ShippingService {
    public String shipGift (PointsGift pointsGift) {
        //物流系统的对接逻辑
        System.out.println(pointsGift.getName() + "进入物流系统");
        return "666";
    }
}
