package ch02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Ch02Section02Consumer {
    public static void main(String[] args) {
     /*   Consumer<String> myStringConsumer = (String str) -> {
            System.out.println(str);
        };*/

        Consumer<String> myStringConsumer = (String str) -> System.out.println(str);


        myStringConsumer.accept("hello");
        myStringConsumer.accept("world");

        List<Integer> integerInputs = Arrays.asList(4, 3, 2); //Immutable
//        integerInputs.add(5); //UnsupportedOperationException
        Consumer<Integer> myIntegerProcessor = (Integer x) ->
            System.out.println("Processing Integer " + x);

        process(integerInputs, myIntegerProcessor);

        Consumer<Integer> myDifferentIntegerProcessor
                = x -> System.out.println("Processing Integer in different way" + x);
        process(integerInputs, myDifferentIntegerProcessor);

        processGeneric(integerInputs, myDifferentIntegerProcessor);

        Consumer<Double> myDoubleProcessor = x -> System.out.println("Processing Double " + x);

        List<Double> doubleInputs = Arrays.asList(1.1, 2.2, 3.3);

        processGeneric(doubleInputs,myDoubleProcessor);

    }

    public static void process(List<Integer> inputs, Consumer<Integer> processor) {
        for (Integer input : inputs) {
            processor.accept(input);
        }
    }

    public static <T> void processGeneric(List<T> inputs, Consumer<T> processor) {
        for (T input : inputs) {
            processor.accept(input);
        }
    }

}
