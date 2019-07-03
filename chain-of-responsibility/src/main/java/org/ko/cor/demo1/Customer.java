package org.ko.cor.demo1;

import org.ko.cor.demo1.handler.PriceHandler;
import org.ko.cor.demo1.handler.PriceHandlerFactory;

import java.util.Random;

/**
 * 客户, 申请折扣
 */
public class Customer {

    private PriceHandler priceHandler;

    public void setPriceHandler(PriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }

    public void requestDiscount (float discount) {
        priceHandler.processDiscount(discount);
    }


    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setPriceHandler(PriceHandlerFactory.createPriceHandler());

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            System.out.print((i + 1) + ":");
            customer.requestDiscount(random.nextFloat());
        }

    }
}
