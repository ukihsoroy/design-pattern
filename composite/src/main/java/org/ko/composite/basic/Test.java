package org.ko.composite.basic;


/**
 * 应用与测试
 */
public class Test {

    public static void main(String[] args) {
        Composite composite = new Composite("树枝1");

        Leaf leaf1 = new Leaf("树枝1树叶1");
        Leaf leaf2 = new Leaf("树枝1树叶2");
        Leaf leaf3 = new Leaf("树枝1树叶3");

        composite.add(leaf1);
        composite.add(leaf2);
        composite.add(leaf3);

        Composite composite1 = new Composite("树");

        Leaf leaf4 = new Leaf("树叶4");
        Leaf leaf5 = new Leaf("树叶5");

        composite1.add(leaf4);
        composite1.add(leaf5);
        composite1.add(composite);

        composite1.operation();
    }
}
