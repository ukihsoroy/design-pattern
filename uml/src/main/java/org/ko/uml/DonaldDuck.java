package org.ko.uml;

/**
 * 唐老鸭
 */
public class DonaldDuck extends Duck implements HumanLanguage {
    @Override
    public void say() {
        System.out.println("说人话");
    }
}
