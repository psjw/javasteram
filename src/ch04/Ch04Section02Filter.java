package ch04;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch04Section02Filter {
    public static void main(String[] args) {
        Stream<Integer> numberStream = Stream.of(3, -5, 7, 10, -3);
        Stream<Integer> filteredNumberStream = numberStream.filter(x -> x > 0);
        List<Integer> filteredNumbers = filteredNumberStream.collect(Collectors.toList());
        System.out.println("filteredNumbers = " + filteredNumbers);
        Stream<Integer> newFilteredNumberStream = Stream.of(3, -5, 7, 10, -3).filter(x -> x > 0);
        List<Integer> newFilteredNubmers = Stream.of(3, -5, 7, 10, -3).filter(x -> x > 0).collect(Collectors.toList());
        System.out.println("newFilteredNubmers = " + newFilteredNubmers);
    }
}
