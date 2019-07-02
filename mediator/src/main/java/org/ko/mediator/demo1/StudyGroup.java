package org.ko.mediator.demo1;

import java.util.Date;

public class StudyGroup {

    public static void showMessage (User user, String message) {
        System.out.println(new Date().toString() + " [" + user + "] :" + message);
    }

}
