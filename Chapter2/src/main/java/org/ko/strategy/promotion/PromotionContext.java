package org.ko.strategy.promotion;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public class PromotionContext {

    private static final String PACKAGE_NAME = "org.ko.strategy.promotion";

    private IPromotionStrategy promotionStrategy;

    public BigDecimal getPrice () {
        return this.promotionStrategy.promotionAlgorithm();
    }

    public void newPromotion (Integer code, Object... args) {
        String clazz = PromotionType.findClazz(code);
        try {
            this.promotionStrategy = (IPromotionStrategy)Class.forName(PACKAGE_NAME + "." + clazz)
                    .getDeclaredConstructor(getClasses(args)).newInstance(args);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setPrice (BigDecimal price) {
        this.promotionStrategy.setPrice(price);
    }

    private Class[] getClasses (Object... args) {
        Class[] classes = new Class[args.length];
        for (int i = 0; i < args.length; i ++) {
            classes[i] = args[i].getClass();
        }
        return classes;
    }

}
