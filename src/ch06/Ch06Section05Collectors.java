package ch06;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch06Section05Collectors {
    public static void main(String[] args) {
        List<Integer> numberList = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.toList());
        System.out.println("numberList = " + numberList);

        Set<Integer> numberSet = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.toSet());
        System.out.println("numberSet = " + numberSet);//순서 상관 X  중복 X

        List<Integer> numberList2 = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.mapping(x -> Math.abs(x), Collectors.toList()));
        System.out.println("numberList2 = " + numberList2);

        Set<Integer> numberSet2 = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.mapping(x -> Math.abs(x), Collectors.toSet()));
        System.out.println("numberSet2 = " + numberSet2);

        int sum = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.reducing(0, (x, y) -> x + y));
        System.out.println("sum = " + sum);
    }
}
