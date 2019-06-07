package org.ko.builder.basic.abstractbuilder;

/**
 * 抽象的构建，每添加新的构建方式，只需要继承这个抽象类即可
 */
public abstract class AProductBuilder {

    /**
     * 构建具体属性，只是mock一个，可以有很多个
     * @param property
     */
    abstract void buildProperty(String property);

    /**
     * 返回被构建的对象
     * @return
     */
    abstract Product makeProduct();
}
