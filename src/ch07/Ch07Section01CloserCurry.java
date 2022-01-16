package ch07;


import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Ch07Section01CloserCurry {
    public static void main(String[] args) {
        Supplier<String> supplier = getStringSupplier();
        System.out.println(supplier.get()); //메서드가 종료해도 hello 가 계속 존재

        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        Function<Integer, Function<Integer, Integer>> curriedAdd = x -> y -> x + y;


        Function<Integer, Integer> addThree = curriedAdd.apply(3);
        int result = addThree.apply(10);
        System.out.println(result);


        Function<Integer, Function<Integer, Integer>> exchangeRate = x -> y -> x * y;
        Function<Integer, Integer> dollarRate = exchangeRate.apply(1190);

        int dollarToKrw = dollarRate.apply(10);
        System.out.println("dollarToKrw = " + dollarToKrw);
        dollarToKrw = dollarRate.apply(10000);
        System.out.println("dollarToKrw = " + dollarToKrw);

    }

    public static Supplier<String> getStringSupplier(){
        String hello = "Hello";
        Supplier<String> supplier = () -> {
            String world = "World";
            return hello + world;
        };
        return supplier;
    }
}
