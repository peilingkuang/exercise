package com.kpl.exercise.proxy;

import com.kpl.exercise.InnerClassExercise;
import com.kpl.exercise.InnerClassExercise1;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TimeMonitorClassProxy implements MethodInterceptor {
    private static final TimeMonitorClassProxy instance = new TimeMonitorClassProxy();
    private TimeMonitorClassProxy() {}

    private static <T>T getProxy(Class<?> cls){
        return (T) Enhancer.create(cls, instance);
    }
    private static <T>T getProxy(Class<?> cls, Class[] argsType, Object[] args){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(instance);
        return (T) enhancer.create(argsType, args);
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        TimeMonitorUtil.start(0);
        Object result = methodProxy.invokeSuper(o, objects);
        TimeMonitorUtil.finish(method.getName());
        return result;
    }

    public static void main(String[] argvs){
        InnerClassExercise in = TimeMonitorClassProxy.getProxy(
                InnerClassExercise1.class, new Class[]{String.class}, new String[]{"test"});
        in.setInnerClass();
        in.getInner().innerFunc();

    }
}
