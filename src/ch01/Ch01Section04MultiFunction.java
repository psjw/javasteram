package ch01;


import ch01.util.TriFunction;

public class Ch01Section04MultiFunction {

    public static void main(String[] args) {
        /*
        TriFunction<Integer, Integer, Integer, Integer> addThreeNumbers = (Integer x, Integer y, Integer z) -> {
            return x + y + z;
        };
        */
        TriFunction<Integer, Integer, Integer, Integer> addThreeNumbers = (x, y, z) -> x + y + z;
        int result = addThreeNumbers.apply(3, 2, 1);
        System.out.println("result = " + result);
    }
}
