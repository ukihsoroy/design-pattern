package org.ko.template.method.demo1;

/**
 * 抽象类
 */
public abstract class AnimalAbstract {

    /**
     *
     */
    public void life () {
        eat();
        sport();
        sleep();
    }

    public abstract void eat ();

    public abstract void sport ();

    public abstract void sleep ();
}
