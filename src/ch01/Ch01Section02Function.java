package ch01;

import java.util.function.Function;

public class Ch01Section02Function {
    public static void main(String[] args) {
        /*Function<Integer, Integer> myAdder = (Integer x) -> {
            return x + 10;
        };*/
        //생략
        Function<Integer, Integer> myAdder =  x -> x + 10;

        int result = myAdder.apply(3);
        System.out.println("result = " + result);
    }
}
