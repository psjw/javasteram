package ch07;


import ch07.model.Order;
import ch07.model.OrderLine;
import ch07.priceprocessor.OrderLineAggregationPriceProcessor;
import ch07.priceprocessor.TaxPriceProcessor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Ch07Section03FunctionComposition {
    public static void main(String[] args) {
        Function<Integer, Integer> multiplyByTwo = x -> x + 2;
        Function<Integer, Integer> addThen = x -> x + 10;

        Function<Integer, Integer> composedFunction = multiplyByTwo.andThen(addThen);
        System.out.println("composedFunction.apply(3) = " + composedFunction.apply(3));

        Order unprocessedOrder = new Order()
                .setId(1001L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));

        List<Function<Order, Order>> priceProcessors = getPriceProcessors(unprocessedOrder);
        Function<Order, Order> mergedPriceProcessors = priceProcessors.stream()
//                .reduce(Function.identity(), (priceProcessor1, priceProcessor2) -> priceProcessor1.andThen(priceProcessor2));
                .reduce(Function.identity(),Function::andThen);
        Order processedOrder = mergedPriceProcessors.apply(unprocessedOrder);
        System.out.println("processedOrder = " + processedOrder);
    }

    public static List<Function<Order, Order>> getPriceProcessors(Order order){
        return Arrays.asList(new OrderLineAggregationPriceProcessor()
                , new TaxPriceProcessor(BigDecimal.valueOf(9.375)));
    }


}
