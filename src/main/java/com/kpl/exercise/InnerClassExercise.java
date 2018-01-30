package com.kpl.exercise;

public class InnerClassExercise {
    private String outParam;
    private InnerClass inner;

    public InnerClassExercise(String outParam) {
        this.outParam = outParam;
    }

    public class InnerClass{
        private String innerParam;

        public void innerFunc(){
            System.out.println("this is a inner func:"+outParam);
        }
    }

    protected class InnerSelector implements Selector{
        private int i = 0;
        @Override
        public boolean end() {
            return i == 10;
        }

        @Override
        public Object current() {
            return i;
        }

        @Override
        public void next() {
            i++;
        }
    }

    public Selector innerSelector(){return new InnerSelector();}

    public void setInnerClass(){
        inner = new InnerClass();
    }

    public String getOutParam() {
        return outParam;
    }

    public void setOutParam(String outParam) {
        this.outParam = outParam;
    }

    public InnerClass getInner() {
        return inner;
    }

    public void setInner(InnerClass inner) {
        this.inner = inner;
    }
}
