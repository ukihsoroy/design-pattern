package org.ko.composite.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * 目录
 */
public class CourseCatalog extends CatalogComponent {

    private List<CatalogComponent> itsms = new ArrayList<>();

    private String name;

    private Integer level;

    public CourseCatalog(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void add(CatalogComponent catalogComponent) {
        this.itsms.add(catalogComponent);
    }

    @Override
    public void remove(CatalogComponent catalogComponent) {
        this.itsms.remove(catalogComponent);
    }

    @Override
    public void print() {
        System.out.println("> " + this.name);
        for (CatalogComponent catalogComponent : itsms) {
            if (this.level != null) {
                for (int i = 0; i < this.level; i ++) {
                    System.out.print("--");
                }
            }
            catalogComponent.print();
        }
    }
}
