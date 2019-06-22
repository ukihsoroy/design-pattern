# 原型模式

## 0x01.定义与类型

- 定义：指原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象
- 特点：不需要知道任何创建的细节，不调用构造函数
- 类型：创建型
- UML
  
  ![原型模式](https://github.com/sigmako/sigmako.github.io/blob/master/%E7%BB%8F%E5%85%B8%E6%9E%B6%E6%9E%84%E6%A1%88%E4%BE%8B%E4%B8%8E%E6%96%B9%E6%B3%95%E8%AE%BA/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/images/prototype1.png)

- 原型模式主要用于对象的复制，它的核心是就是类图中的原型类Prototype。Prototype类需要具备以下两个条件：
  1. 实现Cloneable接口。在java语言有一个Cloneable接口，它的作用只有一个，就是在运行时通知虚拟机可以安全地在实现了此接口的类上使用clone方法。在java虚拟机中，只有实现了这个接口的类才可以被拷贝，否则在运行时会抛出CloneNotSupportedException异常。
  2. 重写Object类中的clone方法。Java中，所有类的父类都是Object类，Object类中有一个clone方法，作用是返回对象的一个拷贝，但是其作用域protected类型的，一般的类无法调用，因此Prototype类需要将clone方法的作用域修改为public类型。
- Java实现

```java
/**
 * 原型模式
 */
public class Prototype implements Cloneable {

    private String name;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * 测试与应用类
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new Prototype();
        prototype.setName("K.O");
        List<String> names = new ArrayList<>();
        names.add("K.O");
        prototype.setNames(names);
        for (int i = 0; i < 5; i ++) {
            Prototype p = (Prototype) prototype.clone();
            p.setName("sigma");
            p.getNames().add("sigma");
            System.out.println(p.toString());
            System.out.println(p.getName());
            System.out.println(p.getNames().size());

        }
        System.out.println(prototype.toString());
        System.out.println(prototype.getName());
        System.out.println(prototype.getNames().size());
    }
}
```

- 测试输出结果

```log
org.ko.prototype.basic.Prototype@1540e19d
sigma
2
org.ko.prototype.basic.Prototype@677327b6
sigma
3
org.ko.prototype.basic.Prototype@14ae5a5
sigma
4
org.ko.prototype.basic.Prototype@7f31245a
sigma
5
org.ko.prototype.basic.Prototype@6d6f6e28
sigma
6
org.ko.prototype.basic.Prototype@135fbaa4
K.O
6
```

- 可以看出，输出结果中对象的地址不同（是重新创建的）
  - 修改基本类型时，并不能影响基础类，而引用对象只是指向的基础类的属性。
  - 这里有个问题叫**深拷贝，浅拷贝**，后续会介绍！
- 原型模式的各个元素，原型模式比较简单，元素比较少
  - 原型接口：适用原型模式要实现原型接口，重写里面的 clone()方法
  - 原型类：具体产品的实现

## 0x02.使用场景

- 类初始化消耗较多资源。
- new产生的一个对象需要非常繁琐的过程（数据准备、访问权限等）。
- 构造函数比较复杂。
- 循环体中生产大量对象时。

## 0x03.优点

- 原型模式性能比直接new一个对象性能高，是在内存中二进制流的拷贝，要比直接new一个对象性能好很多，特别是要在一个循环体内产生大量对象时，原型模式可能更好的体现其优点。
- 还可以简化创建过程。
- 还有一个重要的用途就是保护性拷贝，也就是对某个对象对外可能是只读的，为了防止外部对这个只读对象的修改，通常可以通过返回一个对象拷贝的形式实现只读的限制。

## 0x04.缺点

- 首先要记住原型模式的拷贝时不会执行**构造函数**的。
- clone并不一定比new一个对象快，只有当new对象比较耗时时，才考虑使用原型模式。
- 必须配备克隆方法。
- 对克隆复杂对象或对克隆出的对象进行复杂改造时，容易引入风险。
- 深拷贝、浅拷贝要运用得当。
- 要使用clone方法，类的成员变量上不要增加final关键字，final类型是不允许重赋值的。

## 0x06.样例实现

- 使用原型模式实现发送邮件

- Java代码实现

```java
/**
 * Mail实现类
 * 实现 Cloneable 接口
 * 重写 Object.clone() 方法
 */
public class Mail implements Cloneable {

    private String name;

    private String emailAddress;

    private String content;

    public Mail () {
        System.out.println("Mail Class Constructor!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", content='" + content + '\'' +
                '}' + super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("clone mail object!");
        return super.clone();
    }
}

/**
 * Mail工具类
 */
public class MailUtil {

    public static void sendMail (Mail mail) {
        String outputContent = "向{0}同学, 邮件地址：{1},邮件内容：{2}, 发送邮件成功！";
        System.out.println(MessageFormat.format(
                outputContent,
                mail.getName(),
                mail.getEmailAddress(), mail.getContent())
        );
    }

    public static void saveOriginMailRecord (Mail mail) {
        System.out.println("存储originMail记录, originMail: " + mail.getContent());
    }
}
```

- 测试与应用

```java
/**
 * 测试与应用
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail();
        mail.setContent("初始化模板");

        System.out.println("初始化mail: " + mail.toString());
        for (int i = 0; i < 10; i++) {
            Mail mailTemp = (Mail) mail.clone(); //并没有调用Mail构造器
            mailTemp.setName("K.O_" + i);
            mailTemp.setEmailAddress("ko.shen_" + i + "@hotmail.com");
            mailTemp.setContent("恭喜您中奖了。");
            MailUtil.sendMail(mailTemp);
            System.out.println("克隆的mailTemp: " + mailTemp.toString());
        }
        MailUtil.saveOriginMailRecord(mail);
    }
}
```

- 测试结果

```log
Mail Class Constructor!
初始化mail: Mail{name='null', emailAddress='null', content='初始化模板'}org.ko.prototype.v2.Mail@1540e19d
clone mail object!
向K.O_0同学, 邮件地址：ko.shen_0@hotmail.com,邮件内容：恭喜您中奖了。, 发送邮件成功！
克隆的mailTemp: Mail{name='K.O_0', emailAddress='ko.shen_0@hotmail.com', content='恭喜您中奖了。'}org.ko.prototype.v2.Mail@677327b6
clone mail object!
向K.O_1同学, 邮件地址：ko.shen_1@hotmail.com,邮件内容：恭喜您中奖了。, 发送邮件成功！
克隆的mailTemp: Mail{name='K.O_1', emailAddress='ko.shen_1@hotmail.com', content='恭喜您中奖了。'}org.ko.prototype.v2.Mail@14ae5a5
clone mail object!
向K.O_2同学, 邮件地址：ko.shen_2@hotmail.com,邮件内容：恭喜您中奖了。, 发送邮件成功！
克隆的mailTemp: Mail{name='K.O_2', emailAddress='ko.shen_2@hotmail.com', content='恭喜您中奖了。'}org.ko.prototype.v2.Mail@7f31245a
clone mail object!
向K.O_3同学, 邮件地址：ko.shen_3@hotmail.com,邮件内容：恭喜您中奖了。, 发送邮件成功！
克隆的mailTemp: Mail{name='K.O_3', emailAddress='ko.shen_3@hotmail.com', content='恭喜您中奖了。'}org.ko.prototype.v2.Mail@6d6f6e28
clone mail object!
向K.O_4同学, 邮件地址：ko.shen_4@hotmail.com,邮件内容：恭喜您中奖了。, 发送邮件成功！
克隆的mailTemp: Mail{name='K.O_4', emailAddress='ko.shen_4@hotmail.com', content='恭喜您中奖了。'}org.ko.prototype.v2.Mail@135fbaa4
clone mail object!
向K.O_5同学, 邮件地址：ko.shen_5@hotmail.com,邮件内容：恭喜您中奖了。, 发送邮件成功！
克隆的mailTemp: Mail{name='K.O_5', emailAddress='ko.shen_5@hotmail.com', content='恭喜您中奖了。'}org.ko.prototype.v2.Mail@45ee12a7
clone mail object!
向K.O_6同学, 邮件地址：ko.shen_6@hotmail.com,邮件内容：恭喜您中奖了。, 发送邮件成功！
克隆的mailTemp: Mail{name='K.O_6', emailAddress='ko.shen_6@hotmail.com', content='恭喜您中奖了。'}org.ko.prototype.v2.Mail@330bedb4
clone mail object!
向K.O_7同学, 邮件地址：ko.shen_7@hotmail.com,邮件内容：恭喜您中奖了。, 发送邮件成功！
克隆的mailTemp: Mail{name='K.O_7', emailAddress='ko.shen_7@hotmail.com', content='恭喜您中奖了。'}org.ko.prototype.v2.Mail@2503dbd3
clone mail object!
向K.O_8同学, 邮件地址：ko.shen_8@hotmail.com,邮件内容：恭喜您中奖了。, 发送邮件成功！
克隆的mailTemp: Mail{name='K.O_8', emailAddress='ko.shen_8@hotmail.com', content='恭喜您中奖了。'}org.ko.prototype.v2.Mail@4b67cf4d
clone mail object!
向K.O_9同学, 邮件地址：ko.shen_9@hotmail.com,邮件内容：恭喜您中奖了。, 发送邮件成功！
克隆的mailTemp: Mail{name='K.O_9', emailAddress='ko.shen_9@hotmail.com', content='恭喜您中奖了。'}org.ko.prototype.v2.Mail@7ea987ac
存储originMail记录, originMail: 初始化模板
```

- 从输出信息可以看出来，使用clone方法不需要通过**构造函数**创建

- 由于原型模式uml比较简单，和上面基本一致，这里就不再介绍了！

## 0x05.扩展（深拷贝与浅拷贝）

### 1. 浅克隆

- 直接实现原型模式

```java
/**
 * 浅克隆
 */
public class Pig1 implements Cloneable {
    private String name;

    private Date birthday;

    public Pig1(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Pig1{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}' + super.toString();
    }
}
```

- 测试类
  
```java
public class Test1 {

    public static void main(String[] args) throws CloneNotSupportedException {
        //浅克隆, 没办法克隆引用对象
        Date birthday = new Date(0l);

        Pig1 pig1 = new Pig1("佩奇", birthday);
        Pig1 pig2 = (Pig1) pig1.clone();

        System.out.println(pig1);
        System.out.println(pig2);
        System.out.println("-------");

        pig1.getBirthday().setTime(666666666666L);

        System.out.println(pig1);
        System.out.println(pig2);
    }
}
```

- 输出日志

```log
Pig1{name='佩奇', birthday=Thu Jan 01 08:00:00 CST 1970}org.ko.prototype.clone.Pig1@6d6f6e28
Pig1{name='佩奇', birthday=Thu Jan 01 08:00:00 CST 1970}org.ko.prototype.clone.Pig1@135fbaa4
-------
Pig1{name='佩奇', birthday=Sat Feb 16 09:11:06 CST 1991}org.ko.prototype.clone.Pig1@6d6f6e28
Pig1{name='佩奇', birthday=Sat Feb 16 09:11:06 CST 1991}org.ko.prototype.clone.Pig1@135fbaa4
```

- 如上所示，修改pig1中的birthday，pig2中的也响应了变化，所以直接使用clone方法返回的对象中的引用变量并没有重新创建而是直接复用的原有对象中的变量。
- 由此得出结论：**clone方法默认使用的是浅拷贝。**
- 如果想要引用变量也全部复制？

### 2.深拷贝

- 其实深克隆只是自己实现了引用变量的创建，请看实现：

```java
/**
 * 深克隆
 */
public class Pig2 implements Cloneable {
    private String name;

    private Date birthday;

    public Pig2(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Pig2 pig2 = (Pig2) super.clone();

        //深克隆, 要自己去做对象引用的克隆
        pig2.birthday = (Date) pig2.birthday.clone();
        return pig2;
    }

    @Override
    public String toString() {
        return "Pig1{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}' + super.toString();
    }
}
```

- 测试类

```java
public class Test2 {

    public static void main(String[] args) throws CloneNotSupportedException {
        //深克隆
        Date birthday = new Date(0l);

        Pig2 p1 = new Pig2("佩奇", birthday);
        Pig2 p2 = (Pig2) p1.clone();

        System.out.println(p1);
        System.out.println(p2);
        System.out.println("-------");

        p1.getBirthday().setTime(666666666666L);

        System.out.println(p1);
        System.out.println(p2);
    }
}
```

- 输出日志

```log
Pig2{name='佩奇', birthday=Thu Jan 01 08:00:00 CST 1970}org.ko.prototype.clone.Pig2@6d6f6e28
Pig2{name='佩奇', birthday=Thu Jan 01 08:00:00 CST 1970}org.ko.prototype.clone.Pig2@135fbaa4
-------
Pig2{name='佩奇', birthday=Sat Feb 16 09:11:06 CST 1991}org.ko.prototype.clone.Pig2@6d6f6e28
Pig2{name='佩奇', birthday=Thu Jan 01 08:00:00 CST 1970}org.ko.prototype.clone.Pig2@135fbaa4
```

- 可以看出，修改了pig1的时间，pig2并没有跟着响应。所以深拷贝完成。

## 0x07.原型模式对单例模式的破坏

- 当单例对象实现了clone方法时，会返回多个实例，请看实现：

```java
/**
 * 简单的饿汉式单例
 */
public class StaticInnerClassSingleton implements Cloneable {

    /**
     * 看静态类的初始化锁那个线程可以拿到
     */
    private static class InnerClass {
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return InnerClass.staticInnerClassSingleton;
    }

    private StaticInnerClassSingleton() {
        if (InnerClass.staticInnerClassSingleton != null) {
            throw new RuntimeException("单例对象禁止反射调用");
        }
    }

    /**
     * 直接重写clone方法
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        //获取单例对象
        StaticInnerClassSingleton singleton = StaticInnerClassSingleton.getInstance();
        System.out.println(singleton.toString());

        //clone获取克隆对象
        StaticInnerClassSingleton singleton1 = (StaticInnerClassSingleton) singleton.clone();
        System.out.println(singleton1.toString());
    }
}
```

- 输出日志

```log
org.ko.prototype.singleton.StaticInnerClassSingleton@1540e19d
org.ko.prototype.singleton.StaticInnerClassSingleton@677327b6
```

- 根据日志可以看出，单例模式被破坏掉。
- 重写clone()方法，直接返回INSTANCE对象解决原型模式对单例模式的破坏

```java
/**
 * 简单的饿汉式单例
 */
public class StaticInnerClassSingleton1 implements Cloneable {

    /**
     * 看静态类的初始化锁那个线程可以拿到
     */
    private static class InnerClass {
        private static StaticInnerClassSingleton1 staticInnerClassSingleton = new StaticInnerClassSingleton1();
    }

    public static StaticInnerClassSingleton1 getInstance() {
        return InnerClass.staticInnerClassSingleton;
    }

    private StaticInnerClassSingleton1() {
        if (InnerClass.staticInnerClassSingleton != null) {
            throw new RuntimeException("单例对象禁止反射调用");
        }
    }

    /**
     * 修改克隆方法，返回单例对象
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return InnerClass.staticInnerClassSingleton;
    }
}

/**
 * 修改后的测试类
 */
public class Test1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        //获取单例对象
        StaticInnerClassSingleton1 singleton1 = StaticInnerClassSingleton1.getInstance();
        System.out.println(singleton1.toString());

        //获取clone对象
        StaticInnerClassSingleton1 singleton2 = (StaticInnerClassSingleton1) singleton1.clone();
        System.out.println(singleton2.toString());
    }
}
```

- 输出日志

```log
org.ko.prototype.singleton.StaticInnerClassSingleton1@1540e19d
org.ko.prototype.singleton.StaticInnerClassSingleton1@1540e19d
```

- 可以看出，返回的对象地址时一致的。这样就解决了原型对单例模式的破坏。

## 0x08.源码地址

- `原型模式`: [https://github.com/sigmako/design-pattern/tree/master/prototype](https://github.com/sigmako/design-pattern/tree/master/prototype)

## 0x09.参考

- `慕课网设计模式精讲`: [https://coding.imooc.com/class/270.html](https://coding.imooc.com/class/270.html)
- `设计模式之原型模式`: [https://blog.csdn.net/chenliguan/article/details/69855738](https://blog.csdn.net/chenliguan/article/details/69855738)
- `C06 原型模式 示例（六） 原型模式破坏单例模式`: [https://blog.csdn.net/weixin_33669968/article/details/88889565](https://blog.csdn.net/weixin_33669968/article/details/88889565)
