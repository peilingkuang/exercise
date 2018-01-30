package com.kpl.exercise;

public class InnerClassExercise1 extends InnerClassExercise {
    public InnerClassExercise1(String outParam) {
        super(outParam);
    }

    public static void main(String[] argv){
        InnerClassExercise1 ex = new InnerClassExercise1("asfd");
        Selector s = ex.innerSelector();
        s.next();
        System.out.println(s.current());

        Selector se = ex.new InnerSelector();
        System.out.println(se.current());
    }
}
