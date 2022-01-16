package ch01;

import ch01.util.Adder;

import java.util.function.Function;

public class Ch01Section01Function {
    public static void main(String[] args) {
        Function<Integer, Integer> myAdder= new Adder();
        int result = myAdder.apply(5);
        System.out.println("result = " + result);
    }
}
