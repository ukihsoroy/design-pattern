package org.ko.observer.d2;

/**
 * 测试类
 */
public class Test {

    public static void main(String[] args) {
        Course course = new Course("Javas设计模式精讲");
        Teacher teacher1 = new Teacher("Alpha");
        Teacher teacher2 = new Teacher("Beta");

        course.addObserver(teacher1);
        course.addObserver(teacher2);

        //业务逻辑代码
        Question question = new Question();
        question.setUsername("K.O");
        question.setQuestionContent("Java的主函数如何编写");

        course.produceQuestion(course, question);

    }
}
