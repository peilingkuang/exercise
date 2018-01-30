package com.kpl.exercise.proxy;

public class TimeMonitorUtil {
    public static ThreadLocal<Integer> type = new ThreadLocal<>();
    public static ThreadLocal<Long> tm = new ThreadLocal<>();

    public static void start(Integer timetype) {
        type.set(timetype);
        tm.set(timetype == 0 ? System.currentTimeMillis() : System.nanoTime());
    }

    public static void finish(String method) {
        Long current = (type.get() == null || type.get() == 0 ? System.currentTimeMillis() : System.nanoTime());
        System.out.println(">>>[" + method + "]TimeCost:" + (current - tm.get()) + (type.get() == null || type.get() == 0 ? "ms" : "ns"));
    }

    public static void clear() {
        type = new ThreadLocal<>();
        tm = new ThreadLocal<>();
    }
}
