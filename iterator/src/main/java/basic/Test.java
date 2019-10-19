package basic;


/**
 * 应用与测试
 */
public class Test {

    public static void main(String[] args) {
        ConcreteAggregate aggregate = new ConcreteAggregate();
        aggregate.add(new Object());
        aggregate.add(new Object());
        aggregate.add(new Object());

        Iterator iterator = aggregate.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

    }
}
