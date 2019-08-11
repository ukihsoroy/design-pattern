package org.ko.composite.basic;

import java.util.ArrayList;
import java.util.List;


/**
 * 组合类
 */
public class Composite implements Component {

    private String name;

    private List<Component> components = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    public void add(Component component) {
        components.add(component);
    }

    public void remove (Component component) {
        components.remove(component);
    }

    public Component get(int index) {
        return components.get(index);
    }

    @Override
    public void operation() {
        System.out.println(this.name);
        for (Component component : components) {
            component.operation();
        }
    }
}
