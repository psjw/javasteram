package ch07;


import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch07Section02CloserCurry {
    public static void main(String[] args) {

        //앞에만 계산
        if(true || returnFalse()){
            System.out.println("true");
        }
        //앞에만 계산
        if(resturnTrue() || returnFalse()){
            System.out.println("true");
        }

        //둘다 계산이 된 후에 출력
        if(or(resturnTrue(), returnFalse())){
            System.out.println("true");
        }

        // 앞에만 실행됨 Supplier 의 get에서 실행
        if(lazyOr(() -> resturnTrue(), () -> returnFalse())){
            System.out.println("true");
        }

        Stream<Integer> integerStream = Stream.of(3, -2, 5, 8, -3, 10)
                .filter(x -> x > 0)
                .peek(x -> System.out.println("peeking " + x)) //잠깐 힐끗봄
                .filter(x -> x % 2 == 0);

        System.out.println("Before collect");
        //collect 생성 시점에 stream이 실행됨 -> 종결처리가 되었을때 계산
        List<Integer> integers = integerStream.collect(Collectors.toList());
        System.out.println("After collect = " + integers);
    }

    public static boolean lazyOr(Supplier<Boolean> x, Supplier<Boolean> y){
        return x.get() || y.get();
    }

    public static boolean or(boolean x, boolean y){
        return x || y;
    }


    public static boolean resturnTrue(){
        System.out.println("Returning true");
        return true;
    }

    public static boolean returnFalse(){
        System.out.println("Returning false");
        return false;
    }


}
