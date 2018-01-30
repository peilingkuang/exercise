package com.kpl.exercise;

interface Service{
    void method1();
    void method2();
}

interface ServiceFactory{
    Service getService(int i);
}

class Imp1 implements Service {

    @Override
    public void method1() {
        System.out.println("imp1 method1");
    }

    @Override
    public void method2() {
        System.out.println("imp1 method2");
    }

    public static ServiceFactory factory() {
        return (i)-> {i++;
            System.out.println("inn"+i); return new Imp1();};
    }
}
class Imp2 implements Service {

    @Override
    public void method1() {
        System.out.println("imp2 method1");
    }

    @Override
    public void method2() {
        System.out.println("imp2 method2");
    }
    public static ServiceFactory factory = (i)-> new Imp2();
}
public class InnerClassFactory {
    public static void ConsumerService(ServiceFactory f){
        int i = 1;
        Service s = f.getService(i);
        System.out.println(i);
        s.method1();
        s.method2();
    }

    public static void main(String[] argv){
        InnerClassFactory.ConsumerService(Imp1.factory());
        InnerClassFactory.ConsumerService(Imp2.factory);
    }
}
