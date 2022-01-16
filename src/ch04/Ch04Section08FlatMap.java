package ch04;


import ch04.model.Order;
import ch04.model.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch04Section08FlatMap {
    public static void main(String[] args) {
        String[][] cites = new String[][]{
                {"Seoul","Busan"},
                {"San Francisco","New York"},
                {"Madrid","Barcelona"}
        };
       
        Stream<String[]>  cityStream = Arrays.stream(cites); // {"Seoul","Busan"} 이렇게 받아옴
        Stream<Stream<String>> cityStreamStream = cityStream.map(x -> Arrays.stream(x));
        List<Stream<String>> citySteramList = cityStreamStream.collect(Collectors.toList());
        System.out.println("citySteramList = " + citySteramList);
        //cityStream 재사용불가 이미 사용했으므로
        //map 대신 flatmap 사용
        Stream<String[]> cityStream2 = Arrays.stream(cites);
        Stream<String> flattenedCityStream = cityStream2.flatMap(x -> Arrays.stream(x));//Array를 받아서 stream의 형태로
        List<String> flattenedCityList = flattenedCityStream.collect(Collectors.toList());
        System.out.println("flattenedCityList = " + flattenedCityList);

        Order order1 = new Order()
                .setId(1001)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10001)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(5000)),
                        new OrderLine()
                                .setId(10002)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(4000))
                ));

        Order order2 = new Order()
                .setId(1002)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10003)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(2000)),
                        new OrderLine()
                                .setId(10004)
                                .setType(OrderLine.OrderLineType.DISCOUNT)
                                .setAmount(BigDecimal.valueOf(-1000))
                ));


        Order order3 = new Order()
                .setId(1003)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10005)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(2000))
                ));

        // 카트에 담은걸 한번의 주문으로 만듬
        List<Order> orders = Arrays.asList(order1, order2, order3);
        List<OrderLine> mergedOrderLines = orders.stream()  //Stream<Order>
                .map(Order::getOrderLines) //Stream<List<OrderLine>>
//                .map(List::stream)  //Stream<Stream<OrderLine>>
                .flatMap(List::stream)  //Stream<OrderLine>
                .collect(Collectors.toList());

        System.out.println("mergedOrderLines = " + mergedOrderLines);
    }
}
