# 单例模式

## 0x01.定义与类型

- 定义：保证一个类仅有一个实例，并提供一个全局访问点
- 类型：创建型
- UML
- 单例模式的基本要素
  - 私有的构造方法
  - 指向自己实例的私有静态引用
  - 以自己实例为返回值的静态的公有的方法

## 0x02.适用场景

- 像确保任何情况下都绝对只有一个实例
- 需要频繁实例化然后销毁的对象。
- 创建对象时耗时过多或者耗资源过多，但又经常用到的对象。
- 有状态的工具类对象。
- 频繁访问数据库或文件的对象。

## 0x03.单例模式的优缺点

### 1.优点

- 在内存里只有一个实例，减少了内存开销
- 可以避免对资源的多重占用
- 避免重复创建对象，提高性能
- 设置全局访问点，严格控制访问

### 2.缺点

- 没有接口，扩展困难
- 违反开闭原则

## 0x04.单例模式的几种实现方式

### 1.饿汉式

- 饿汉式：顾名思义，对象比较饥饿，所以一开始就创建好了。饿汉式也是单例模式的最简单实现。

- Java实现

```java
/**
 * 饿汉式
 * 一开始就new好了
 */
public class HungrySingleton implements Serializable {

    /**
     * 可以直接new也可以适用静态块中创建
     * */
    private final static HungrySingleton hungrySingleton;

    static {
        hungrySingleton = new HungrySingleton1();
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }
    /**
     * 私有构造函数
     */
    private HungrySingleton() {}
}
```

- 饿汉式的单例模式，对象一开始就创建好了。不需要考虑线程安全问题。
- 饿汉式单例模式如果消耗资源比较多，而对象未被适用则会造成资源浪费。

### 2.懒汉式

- 懒汉式：说明类对象比较懒，没有直接创建，而是延迟加载的，是第一次获取对象的时候才创建。懒汉式的单例模式应用较多。

#### a.第一个版本的Java实现（非线程安全）

```java
/**
 * 懒汉式
 * 线程不安全
 */
public class LazySingleton {

    private static LazySingleton lazySingleton = null;

    //线程不安全，当有两个线程同时创建对象，会违背单例模式
    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            //会发生指令重排
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
    private LazySingleton() {}
}

```

- 这个版本的懒汉式会出现线程安全的问题，当两个线程同时访问getInstance()静态方法时，lazySingleton还未创建，就会创建出两个实例，违背了单例模式。
- 这里可以在getInstance()方法添加同步锁**synchronized**解决，也可以在方法体添加类锁，但是这样相当于完全锁住了getInstance()，会出现性能问题。
- 推荐适用下面这种方式

#### b.双重检查锁double check懒汉式（线程安全，通常适用这种方式）

```java
/**
 * 懒汉式
 * 线程不安全
 */
public class LazyDoubleCheckSingleton {

    //volatile 禁止指令重排序
    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;

    /**
     * 在静态方法中直接加synchronized相当于锁了类
     * @return
     */
    public static LazyDoubleCheckSingleton getInstance() {
        //同样实锁类, 指令重排序
        if (lazyDoubleCheckSingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazyDoubleCheckSingleton == null) {
                    /**
                     * 1.分配内存给这个对象
                     * 2.初始化对象
                     * 3.设置lazyDoubleCheckSingleton指向刚分配的内存
                     * 2 3 顺序有可能发生颠倒
                     * intra-thread semantics 不会改变单线程执行结果，指令重排序
                     */
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }
    private LazyDoubleCheckSingleton() {}
}
```

- 双重检查，只有对象为空的时候才会需要同步锁，而第二次判断是否为null，是对象是否已经创建。
- 添加**volatile**关键字，防止指令重排序。

#### c.基于静态内部类的延迟加载方案

- 私有静态类的延迟加载

```java
public class StaticInnerClassSingleton {

    /**
     * 看静态类的初始化锁那个线程可以拿到
     */
    private static class InnerClass {
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return InnerClass.staticInnerClassSingleton;
    }

    private StaticInnerClassSingleton () {
        if (InnerClass.staticInnerClassSingleton != null) {
            throw new RuntimeException("单例对象禁止反射调用");
        }
    }
}
```

- 将延迟初始化交给静态类的初始化

### 3.容器单例

- 使用静态容器方式来实现多单例类

```java
public class ContainerSingleton {

    //静态容器， 注意map不是线程安全的，如果为了线程安全可以使用HashTable或者ConcurrentHashMap
    private static Map<String, Object> singletonMap = new HashMap<>();

    public static void putInstance (String key, Object instance) {
        if (key != null && key.length() != 0) {
            if (!singletonMap.containsKey(key)) {
                singletonMap.put(key, instance);
            }
        }
    }

    public static Object getInstance (String key) {
        return singletonMap.get(key);
    }
}
```

- 容器单例如果要保证线程安全性，建议使用ConcurrentHashMap
- 通常使用容器单例情况是：单例对象比较多，需要统一维护。

### 4.枚举单例模式（推荐使用）

- 枚举单例是从JVM层面上做的限制

```java
public enum EnumInstance {

    /**
     * 具体的单例实例
     */
    INSTANCE {
        protected void  printTest () {
            System.out.println("K.O print Test!");
        }
    };
    private Object data;
    protected abstract void printTest();
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public static EnumInstance getInstance() {
        return INSTANCE;
    }
}
```

- 后续会介绍到，单例模式完美防御了反射与序列化攻击

### 5.ThreadLocal线程单例（并不是严格意义上的单例模式）

- 有一部分场景，要求对象的生命周期随着线程

```java
/**
 * 线程级单例模式
 */
public class ThreadLocalInstance {

    //静态的ThreadLocal类保存对象
    private static final ThreadLocal<ThreadLocalInstance> threadLocal =
            ThreadLocal.withInitial(ThreadLocalInstance::new);

    private ThreadLocalInstance () {}

    public static ThreadLocalInstance getInstance () {
        return threadLocal.get();
    }
}
```

- 通过getInstance()获取该线程的实例。

## 0x05.单例模式的序列化与反射攻击

### 1.序列化攻击

- 以前面饿汉式举例
- 测试代码

```java
public class SerializableTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1.实例化
        HungrySingleton instance = HungrySingleton.getInstance();

        //2.写入本地文件
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
        oos.writeObject(instance);

        //3.读取
        File file = new File("singleton_file");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        HungrySingleton newInstance = (HungrySingleton) ois.readObject();

        //4.比较
        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);
    }
}
```

- 输出结果

```log
org.ko.singleton.hungry.HungrySingleton@135fbaa4
org.ko.singleton.hungry.HungrySingleton@568db2f2
false
```

- 解决方案：添加**readResolve()**方法

- 修改后

```java
/**
 * 饿汉式
 * 一开始就new好了
 */
public class HungrySingleton implements Serializable {

    private final static HungrySingleton hungrySingleton;

    static {
        hungrySingleton = new HungrySingleton();
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    /**
     * 写完后，序列化对象会通过反射调用这个方法
     * 完全是ObjectInputStream写死的，并没有任何继承关系
     * 其实每次序列化 反序列化 都已经创建对象了，只是最后返回的这一个
     * @return
     */
    private Object readResolve () {
        return hungrySingleton;
    }

    private HungrySingleton() {}
}

```

- 输出结果

```log
org.ko.singleton.hungry.HungrySingleton@135fbaa4
org.ko.singleton.hungry.HungrySingleton@135fbaa4
true
```

- 为什么添加了**readResolve()**方法就可以了?
  - ObjectInputStream源码中，读取文件时写死判断是否有readResolve()方法，有调用这个方法，没有则重新创建对象。

### 2.反射攻击

- 通过反射攻击，实例化对象创建出第二个单例对象

```java
/**
 * 类加载时就已经创建好对象
 */
public class ReflectTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class objectClass = HungrySingleton.class;

        Constructor constructor = objectClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        //反射创建
        HungrySingleton instance = HungrySingleton.getInstance();

        //正常创建
        HungrySingleton newInstance = (HungrySingleton) constructor.newInstance();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);

        //StaticInnerClassSingleton类也是一样的
    }
}
```

- 测试结果

```log
org.ko.singleton.hungry.HungrySingleton@1540e19d
org.ko.singleton.hungry.HungrySingleton@677327b6
false
```

- 解决办法：在构造方法抛出异常

```java
/**
 * 饿汉式
 * 一开始就new好了
 */
public class HungrySingleton implements Serializable {

    private final static HungrySingleton hungrySingleton;

    static {
        hungrySingleton = new HungrySingleton();
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    /**
     * 写完后，序列化对象会通过反射调用这个方法
     * 完全是ObjectInputStream写死的，并没有任何继承关系
     * 其实每次序列化 反序列化 都已经创建对象了，只是最后返回的这一个
     * @return
     */
    private Object readResolve () {
        return hungrySingleton;
    }

    private HungrySingleton() {
        /**
         * 对一开始就创建好了的类有效
         */
        if (hungrySingleton != null) {
            throw new RuntimeException("单例对象禁止反射调用");
        }
    }
}
```

- 再次测试输出结果

```log
Exception in thread "main" java.lang.reflect.InvocationTargetException
  at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
  at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
  at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
  at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
  at org.ko.singleton.ReflectTest1.main(ReflectTest1.java:23)
Caused by: java.lang.RuntimeException: 单例对象禁止反射调用
  at org.ko.singleton.hungry.HungrySingleton2.<init>(HungrySingleton2.java:36)
  ... 5 more
```

- 注意使用这种方式防止反射攻击，饿汉式正常，懒汉式因为创建对象的时机不同还是会出现问题，这种方式只能做到尽量的防御。

### 3.关于枚举单例模式防止序列化与反射

- 枚举模式的实例天然具有线程安全性，防止序列化与反射的特性
- 验证代码

```java
/**
 * 枚举类测试
 */
public class SerializableTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //测试枚举类型
        EnumInstance instance = EnumInstance.getInstance();
        //设置对象
        instance.setData(new Object());

        //写入文件
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
        oos.writeObject(instance);

        //读取文件
        File file = new File("singleton_file");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        EnumInstance newInstance = (EnumInstance) ois.readObject();

        //比较实例
        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);

        //比较实例中引用对象
        System.out.println(instance.getData());
        System.out.println(newInstance.getData());
        System.out.println(instance.getData() == newInstance.getData());
    }
}
```

- 测试结果：

```log
INSTANCE
INSTANCE
true
java.lang.Object@5fd0d5ae
java.lang.Object@5fd0d5ae
true
```

- 反射攻击测试

```java
/**
 * 类加载时就已经创建好对象
 */
public class ReflectTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class objectClass = EnumInstance.class;

        Constructor constructor = objectClass.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);

        //反射对象
        EnumInstance newInstance = (EnumInstance) constructor.newInstance("K.O", 1);
        //实例对象
        EnumInstance instance = EnumInstance.getInstance();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);
    }
}

```

- 测试结果，枚举类没办法通过构造函数创建实例

```log
Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects
  at java.lang.reflect.Constructor.newInstance(Constructor.java:417)
  at org.ko.singleton.ReflectTest3.main(ReflectTest3.java:21)
```

- 枚举类反编译结果

```java
//final的
public final class EnumInstance extends Enum{
    public static EnumInstance[] values(){
        return (EnumInstance[])$VALUES.clone();
    }

    public static EnumInstance valueOf(String name){
        return (EnumInstance)Enum.valueOf(org/ko/singleton/byenum/EnumInstance, name);
    }

    //私有构造器
    private EnumInstance(String s, int i){
        super(s, i);
    }

    public Object getData(){
        return data;
    }

    public void setData(Object data){
        this.data = data;
    }

    public static EnumInstance getInstance(){
        return INSTANCE;
    }

    //static final
    public static final EnumInstance INSTANCE;
    private Object data;
    private static final EnumInstance $VALUES[];

    //通过静态块加载它，比较像饿汉模式
    static {
        INSTANCE = new EnumInstance("INSTANCE", 0);
        $VALUES = (new EnumInstance[] {
            INSTANCE
        });
    }
}
```

- 结论：如果不是特别重的对象，建议使用枚举单例模式，它是JVM天然的单例。

## 0x06.单例模式关注的重点

1. 私有构造器
2. 线程安全
3. 延迟加载
4. 序列化和反序列化安全
5. 反射攻击安全

## 0x07.相关设计模式

- 单例模式和工厂模式：工厂类可以设计成单例模式。
- 单例模式和享元模式：可以通过享元模式来获取单例对象

## 0x08.相关代码

`单例模式`：[https://github.com/sigmako/design-pattern/tree/master/singleton](https://github.com/sigmako/design-pattern/tree/master/singleton)

## 0x09.参考文章

- `慕课网设计模式精讲`: [https://coding.imooc.com/class/270.html](https://coding.imooc.com/class/270.html)
- `23种设计模式（1）：单例模式`: [https://blog.csdn.net/zhengzhb/article/details/7331369](https://blog.csdn.net/zhengzhb/article/details/7331369)
