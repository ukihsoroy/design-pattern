package org.ko.composite.v1;

/**
 * 通用的抽象类
 */
public abstract class CatalogComponent {

    public void add (CatalogComponent catalogComponent) {
        throw new UnsupportedOperationException("不支持添加操作");
    }

    public void remove (CatalogComponent catalogComponent) {
        throw new UnsupportedOperationException("不支持删除操作");
    }

    public String getName () {
        throw new UnsupportedOperationException("不支持获取名称操作");
    }

    public Double getPrice () {
        throw new UnsupportedOperationException("不支持获取价钱操作");
    }

    public void print () {
        throw new UnsupportedOperationException("不支持打印操作");
    }

}
