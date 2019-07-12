# 外观/门面 模式

## 0x01.定义与类型

- 定义：又叫门面模式，提供了一个统一的接口，用来访问子系统中的一群接口
- 外观模式定义了一个高层接口，让子系统更容易使用
- 类型：结构型

- 门面模式是对系统复杂的关系处理做了一个封装，对外提供一个简单的接口，成员介绍：
  - 子系统：被门面模式封装的子系统，也是具体业务逻辑的细节
  - facade类：门面类，对子系统执行流程进行封装，对外开放功能接口，一般为单例对象。

## 0x02.适用场景

- 子系统越来越复杂，增加外观模式提供简单调用接口
- 构建多层系统结构，利用外观对象作为每层的入口，简化层间调用

## 0x03.优点

- 简化了调用过程，无需了解深入子系统，防止带来风险
- 减少系统依赖、松散耦合
- 更好的划分访问层次
- 符合迪米特法则，即最少知道原则

## 0x04.缺点

- 增加子系统，需要修改门面类，容易引入风险。
- 修改门面类，不符合开闭原则

## 0x05.样例代码

> 场景：假设积分兑换物品流程，一共有三部分别依赖三个子系统
> 1.积分校验系统，查看是否有资格。
> 2.积分支付系统，兑换礼物，扣减积分等。
> 3.物流系统，兑换礼物后，进行配送流程。

- 如果不适用门面模式，需要在客户端进行三个步骤的调用，而门面封装后只需要使用门面类，下面具体代码实现:

```java
/**
 * 礼物实体类
 */
public class PointsGift {

    private String name;

    public PointsGift(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * 支付子系统
 */
public class PointsPaymentService {
    public boolean pay(PointsGift pointsGift) {
        //扣减积分
        System.out.println("支付：" + pointsGift.getName() + " 积分成功！");
        return true;
    }
}

/**
 * 积分校验子系统
 */
public class QualifyService {

    public boolean isAvailable (PointsGift pointsGift) {
        System.out.println("校验" + pointsGift.getName() + "积分资格通过，库存通过");
        return true;
    }
}

/**
 * 物流子系统
 */
public class ShippingService {
    public String shipGift (PointsGift pointsGift) {
        //物流系统的对接逻辑
        System.out.println(pointsGift.getName() + "进入物流系统");
        return "666";
    }
}

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
```

- 测试与调用类

```java
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
```

- 测试输出结果：

```log
校验连衣裙积分资格通过，库存通过
支付：连衣裙 积分成功！
连衣裙进入物流系统
物流订单号：666
```


## 0x06.相关的设计模式

- 外观模式和中介者模式
  - 外观模式关注的是外界和子系统直接的交互
  - 中介者模式关注的是子系统之间的交互
- 外观模式和单例模式
  - 外观模式中外观对象可以做成单例对象来使用
- 外观模式和抽象工厂模式
  - 外观类可以通过抽象工厂获取子系统实例
  - 子系统可以在内部对外观类进行屏蔽

## 0x07.源码中的外观模式

- SpringJDBC中的：JdbcUtils是对JDBC的封装
- MyBatis: Configuration中new开头的方法
- Tomcat: RequestFacade类
- Tomcat: Request类
- Tomcat: ResponseFacade类
- Tomcat: StandardSessionFacade类

## 0x08.代码地址

`门面模式`: [https://github.com/sigmako/design-pattern/tree/master/facade](https://github.com/sigmako/design-pattern/tree/master/facade)

## 0x09.参考

- `慕课网设计模式精讲`: [https://coding.imooc.com/class/270.html](https://coding.imooc.com/class/270.html)
- `门面模式`: [https://www.cnblogs.com/skywang/articles/1375447.html](https://www.cnblogs.com/skywang/articles/1375447.html)
