package org.ko.proxy.basic.stati;

/**
 * @author zhiyuan.shen
 */
public class Test {

    public static void main(String[] args) {
        //创建服务类
        RealSubject realSubject = new RealSubject();
        //自己执行方法
        realSubject.doAction();

        System.out.println("----------");

        //创建代理类
        Proxy proxy = new Proxy(realSubject);
        //代理执行
        proxy.doAction();

    }
}
