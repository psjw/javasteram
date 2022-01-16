package ch04;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch04Section04Map {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(3, 6, -4);
        Stream<Integer> numberStream = numberList.stream();
        Stream<Integer> numberStreamX2 = numberStream.map(x -> x * 2);
        List<Integer> numberListX2 = numberStreamX2.collect(Collectors.toList());
        System.out.println("numberListX2 = " + numberListX2);

        List<Integer> numberListX3 = numberList.stream().map(x -> x*2 ).collect(Collectors.toList());
        System.out.println("numberListX3 = " + numberListX3);

        Stream<Integer> numberListStream = numberList.stream();
        Stream<String> strStream = numberListStream.map(x -> "Number is " + x);
        List<String> strList = strStream.collect(Collectors.toList());
        System.out.println("strList = " + strList);
    }
}
