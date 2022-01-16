package ch06;

import ch06.model.Order;
import ch06.model.OrderLine;
import ch06.model.User;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Ch06Section04Reduce {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, -2, -5, 3);
        int sum = numbers.stream()
                .reduce((x, y) -> x + y) // ((((1+4) + (-2))+ (-5))+3)
                .get();

        int min = numbers.stream()
                .reduce((x, y) -> {
                    if (x < y) {
                        return x;
                    } else {
                        return y;
                    }
                }).get();
        System.out.println("min = " + min);

        int min2 = numbers.stream()
                .reduce((x, y) -> x < y ? x : y).get();

        System.out.println("min2 = " + min2);

        int product = numbers.stream()
                .reduce(1, (x, y) -> x * y); //get 필요 없음 항상 없으면 1리턴
        System.out.println("product = " + product);

        List<String> numberStrList = Arrays.asList("3", "2", "5", "-4");
        int sumOfNumberStrList = numberStrList.stream()
                .map(Integer::parseInt)
                .reduce(0, (x, y) -> x + y);
        System.out.println("sumOfNumberStrList = " + sumOfNumberStrList);

        int sumOfNumberStrList2 = numberStrList.stream()
                .reduce(0, (number, str) -> number + Integer.parseInt(str), (num1, num2) -> num1 + num2);

        System.out.println("sumOfNumberStrList2 = " + sumOfNumberStrList2);

        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setFriendUserIds(Arrays.asList(201, 202, 203, 204));

        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setFriendUserIds(Arrays.asList(204, 205, 206));

        User user3 = new User()
                .setId(103)
                .setName("Charlie")
                .setFriendUserIds(Arrays.asList(204, 205, 207));
        List<User> users = Arrays.asList(user1, user2, user3);
        int sumOfNumberOfFriends = users.stream()
                .map(User::getFriendUserIds)
                .map(List::size) //4 , 3, 3
                .reduce(0, (x, y) -> x + y);
        System.out.println("sumOfNumberOfFriends = " + sumOfNumberOfFriends);


        Order order1 = new Order()
                .setId(1001L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));
        Order order2 = new Order()
                .setId(1002L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(2000)),
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(3000))));
        Order order3 = new Order()
                .setId(1002L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));
        List<Order> orders = Arrays.asList(order1, order2, order3);

        // TODO: find the sum of amounts by orderline
       BigDecimal sumOfAmountOrderLine = orders.stream()
                .map(Order::getOrderLines) //Stream<List<OrderLine>>
                .flatMap(List::stream)      //Stream<OrderLine>
                .map(OrderLine::getAmount) //Stream<BigDecimal>
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("sumOfAmountOrderLine = " + sumOfAmountOrderLine);

    }
}
