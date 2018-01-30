package com.kpl.exercise.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TimeMonitorProxy<T> implements InvocationHandler {
    T target;

    public TimeMonitorProxy(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        TimeMonitorUtil.start(0);
        Object result = method.invoke(this.target, args);
        TimeMonitorUtil.finish(method.getName());
        return result;
    }

    public T getProxy(){
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                this.target.getClass().getInterfaces(), this);
    }
}
