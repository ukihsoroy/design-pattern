package basic;

import java.util.ArrayList;
import java.util.List;

/**
 * 聚合实现类
 */
public class ConcreteAggregate implements Aggregate {

    private List<Object> contains;

    public ConcreteAggregate () {
        contains = new ArrayList<>();
    }

    public boolean add (Object object) {
        return contains.add(object);
    }

    public boolean remove(Object object) {
        return contains.remove(object);
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this.contains);
    }
}
