package org.ko.uml;

/**
 * 唐老鸭
 */
public class DonaldDuck extends Duck implements IHumanLanguage {
    @Override
    public void say() {
        System.out.println("说人话");
    }
}
