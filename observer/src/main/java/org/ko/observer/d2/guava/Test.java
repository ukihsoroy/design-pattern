package org.ko.observer.d2.guava;

import com.google.common.eventbus.EventBus;

/**
 * 测试
 */
public class Test {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        GuavaEvent guavaEvent = new GuavaEvent();
        eventBus.register(guavaEvent);
        eventBus.post("post的内容");
    }
}
