package com.kpl.exercise;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Sequence {
    private Object[] item;
    private int next = 0;

    public Sequence(int size) {
        this.item = new Object[size];
    }
    public void add(Object item){
        if (next < this.item.length){
            this.item[next++] = item;
        }
    }
    public Selector selector(){
        return new SequenceSelector();
    }

    public class SequenceSelector implements Selector{
        private int i = 0;
        public boolean end() {
            return i == item.length;
        }

        public Object current() {
            return item[i];
        }

        public void next() {
            i++;
        }
    }

    public static void main(String[] argv){
        Sequence sequence = new Sequence(10);
        Selector selector = sequence.selector();
        for (int i = 0 ; i < 10; i++){
            sequence.add(Integer.toString(i));
        }
        while (!selector.end()){
            System.out.println(selector.current());
            selector.next();
        }

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,2,4,234,3,8,3,4,43,67,4,34,3,43,45,100);
        List<Integer> mapList = list.stream().map(t->t*2).collect(Collectors.toList());
        System.out.println("mapList:"+mapList);

        List<Integer> mapParallelList = list.stream().parallel().map(t->t*2).collect(Collectors.toList());
        System.out.println("mapparallel"+mapParallelList);

        List<Integer> filterList = list.stream().filter(t->t==2).map(t->t*2).collect(Collectors.toList());
        System.out.println("filterlist"+filterList);

        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        final Optional<Integer> sum = numbers.stream()
                .reduce((a, b) -> a + b);
        sum.orElseGet(() -> 0);
        System.out.println("reduce"+sum);
        final Integer integer = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("reduce has initialize"+integer);
    }
}
