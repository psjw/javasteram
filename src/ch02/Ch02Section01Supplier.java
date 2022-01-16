package ch02;

import java.util.function.Supplier;

public class Ch02Section01Supplier {
    public static void main(String[] args) {

/*
        Supplier<String> myStringSupplier = () -> {
            return "hello world!";
        };
*/
        Supplier<String> myStringSupplier = () -> "hello world!";
        System.out.println("myStringSupplier.get() = " + myStringSupplier.get());

        Supplier<Double> myRandomDobuleSupplier = () -> Math.random();
        System.out.println("myRandomDobuleSupplier = " + myRandomDobuleSupplier.get());
        System.out.println("myRandomDobuleSupplier = " + myRandomDobuleSupplier.get());
        System.out.println("myRandomDobuleSupplier = " + myRandomDobuleSupplier.get());

        printRandomDoubles(myRandomDobuleSupplier, 5);

    }

    public static void printRandomDoubles(Supplier<Double> randomSupplier, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(randomSupplier.get());
        }
    }
}
