package org.ko.mediator.demo1;

import java.util.Date;

/**
 * 中介者类
 */
public class StudyGroup {

    //发送消息
    public static void showMessage (User user, String message) {
        System.out.println(new Date().toString() + " [" + user.getName() + "] :" + message);
    }
}
