package org.ko.flyweight.v1;


/**
 * 测试与应用
 */
public class Test {

    private static final String[] departments = {"RD", "QA", "PM", "BD"};

    /**
     * 要注意线程安全的问题
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i ++) {
            String department = departments[(int) (Math.random() * departments.length)];
            Manager manager = (Manager) EmployeeFactory.getManager(department);
            manager.report();
        }

        System.out.println(EmployeeFactory.size());
    }
}
