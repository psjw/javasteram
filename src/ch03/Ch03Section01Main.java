package ch03;


import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Ch03Section01Main {
    public static int calculate(int x, int y, BiFunction<Integer, Integer, Integer> operator) {
        return operator.apply(x, y);
    }

    public static int multiply(int x, int y){
        return x * y;
    }

    public int subtract(int x, int y){
        return x - y;
    }

    public void myMethod(){
//        this.subtract(8, 2);
        System.out.println(calculate(10,3, this::subtract));
    }

    public static void main(String[] args) {
        int a = Integer.parseInt("15");
        Function<String, Integer> str2Int = Integer::parseInt;
        System.out.println(str2Int.apply("20"));
        System.out.println(str2Int.apply("20") instanceof Integer);

        String str = "hello";
        boolean b = str.equals("world");
        Predicate<String> equalsToHello = str::equals;
        System.out.println(equalsToHello.test("hello"));
        System.out.println(equalsToHello.test("world"));

        System.out.println(calculate(8, 2, (x, y) -> x + y));

        System.out.println(calculate(8,2, Ch03Section01Main::multiply));
        Ch03Section01Main ch03Section01Main = new Ch03Section01Main();
        System.out.println(calculate(8,2, ch03Section01Main::subtract));

        ch03Section01Main.myMethod();
    }


}
