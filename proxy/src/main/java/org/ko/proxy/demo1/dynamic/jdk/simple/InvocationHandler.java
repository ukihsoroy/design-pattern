package org.ko.proxy.demo1.dynamic.jdk.simple;

import java.lang.reflect.Method;

public interface InvocationHandler {
    void invoke(Object object, Method method);
}
