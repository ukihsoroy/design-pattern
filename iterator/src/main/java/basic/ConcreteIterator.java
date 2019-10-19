package basic;

import java.util.List;

/**
 * 迭代器接口
 */
public class ConcreteIterator implements Iterator {

    private List<Object> contains;

    private int position = 0;

    private Object object;

    public ConcreteIterator(List<Object> contains) {
        this.contains = contains;
    }


    @Override
    public boolean hasNext() {
        return contains.size() > position;
    }

    @Override
    public Object next() {
        object = contains.get(position);
        position ++;
        return object;
    }
}
