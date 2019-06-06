package org.ko.decorator.brekker.v1;

public class Test {

    /**
     * 买煎饼果子
     * @param args
     */
    public static void main(String[] args) {
        //默认
        Battercake battercake = new Battercake();
        System.out.println(battercake.getDesc() + "销售价格：" + battercake.cost());

        //加一个鸡蛋
        Battercake battercakeWithEgg = new BattercakeWithEgg();
        System.out.println(battercakeWithEgg.getDesc() + "销售价格：" + battercakeWithEgg.cost());

        //加一个鸡蛋一个香肠
        Battercake battercakeWithEggSausage = new BattercakeWithEggSausage();
        System.out.println(battercakeWithEggSausage.getDesc() + "销售价格：" + battercakeWithEggSausage.cost());

        //客人要加两个鸡蛋，这里就出现问题了

    }
}
