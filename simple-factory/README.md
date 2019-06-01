# 简单工厂模式

## 0x01.定义与类型

- 定义：由一个工厂对象决定创建出哪一种产品类的实例。
- 类型：创建型，但不属于GOF23中设计模式。
- 简介：通过一个专门的工厂类来创建其他类，这些被创建的类通常有一个共同的父类或接口。

## 0x02.适用场景

- 工厂类负责创建的对象比较少
- 客户端（应用层）只知道传入工厂类的参数，对于如何创建对象（逻辑）不关心

## 0x03.简单工厂的优缺点

- 优点：只需要传入一个正确的参数，就可以获取你所需要的对象，而无须知道其创建细节
- 缺点：工厂类的职责相对过重，增加新的产品，需要修改工厂类的判断逻辑，违背开闭原则

## 0x04.简单工厂的实线样例

- 假设IT教育课程，具有Java, Python等视频。他们都是视频类的子类，而有单独的视频工厂生产这些课程！
- 课程基类

```java
public abstract class Video {
    public abstract void produce();
}
```

- 视频工厂

```java
public class VideoFactory {
    /**
     * 每次新增加产品实线会修改代码
     * 不符合开闭原则
     * @param type
     * @return
     */
    public Video getVideo(String type) {
        if ("java".equalsIgnoreCase(type)) {
            return new JavaVideo();
        } else if ("python".equalsIgnoreCase(type)) {
            return new PythonVideo();
        } else return null;
    }

    /**
     * 反射方式实现
     * @param clazz
     * @return
     */
    public Video getVideo(Class clazz) {
        Video video = null;
        try {
            video = (Video) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return video;
    }
}
```

- Java, Python视频的具体实线类

```java
public class JavaVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制Java课程视频");
    }
}
```

```java
public class PythonVideo extends Video{
    @Override
    public void produce() {
        System.out.println("录制Python课程");
    }
}
```

- 最后的测试类，测试视频工厂输出的视频

```java
public class Test {

//    public static void main(String[] args) {
//        Video video = new JavaVideo();
//        video.produce();
//    }

    public static void main(String[] args) {
        VideoFactory videoFactory = new VideoFactory();
        Video video1 = videoFactory.getVideo("python");
        if (video1 != null) {
            video1.produce();
        }
        Video video2 = videoFactory.getVideo("java");
        if (video2 != null) {
            video2.produce();
        }
    }

   /* public static void main(String[] args) {
        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo(PythonVideo.class);
        if (video != null) {
            video.produce();
        }
    }*/
}
```

- 输出结果

```log
录制Python课程
录制Java课程视频
```

## 0x05.UML类图

![简单工厂UML类图](https://github.com/sigmako/2-master/blob/master/%E7%BB%8F%E5%85%B8%E6%9E%B6%E6%9E%84%E6%A1%88%E4%BE%8B%E4%B8%8E%E6%96%B9%E6%B3%95%E8%AE%BA/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/images/simple-factory-uml.png)

- 如图uml所示：直接的应用类中并没有于具体实现类的耦合，这样当新增具体实现类时是不需要修改应用层业务逻辑

## 0x06.源码中的简单工厂

- Calendar.createCalendar()：JDK时间处理类

```java
//根据输入参数区分的具体实现
if (aLocale.hasExtensions()) {
    String caltype = aLocale.getUnicodeLocaleType("ca");
    if (caltype != null) {
        switch (caltype) {
        case "buddhist":
        cal = new BuddhistCalendar(zone, aLocale);
            break;
        case "japanese":
            cal = new JapaneseImperialCalendar(zone, aLocale);
            break;
        case "gregory":
            cal = new GregorianCalendar(zone, aLocale);
            break;
        }
    }
}
```

- jdbc的Class.forname("com.mysql.driver")：通过每个db推出的不同的驱动，通过反射创建出连接。

## 0x07.相关代码

- `简单工厂模式`：[https://github.com/sigmako/design-pattern/tree/master/simple-factory](https://github.com/sigmako/design-pattern/tree/master/simple-factory)

## 0x08.推荐阅读

- `慕课网设计模式精讲`: [https://coding.imooc.com/class/270.html](https://coding.imooc.com/class/270.html)
- `简单工厂模式`：[https://blog.csdn.net/weiwenlongll/article/details/6918164](https://blog.csdn.net/weiwenlongll/article/details/6918164)