package ch01;

import java.util.function.BiFunction;

/**
 * packageName : ch01
 * fileName : CH01Section03Main
 * author : psjw
 * date : 2022-01-15
 * description :
 * ===========================================================
 * DATE              AUTHOR          NOTE
 * -----------------------------------------------------------
 * 2022-01-15        psjw         최초 생성
 */
public class Ch01Section03BiFunction {
    public static void main(String[] args) {
/*
        BiFunction<Integer, Integer, Integer> add = (Integer x, Integer y) -> {
            return x + y;
        };
*/
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        int result = add.apply(3, 5);
        System.out.println("result = " + result);
    }
}
