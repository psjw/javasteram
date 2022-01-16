package ch04;


import ch04.model.Order;
import ch04.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ch04Section03Filter {
    public static void main(String[] args) {
        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@test.co.kr");

        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("bob@test.co.kr");

        User user3 = new User()
                .setId(103)
                .setName("Charlie")
                .setVerified(true)
                .setEmailAddress("charlie@test.co.kr");
        List<User> users = Arrays.asList(user1, user2, user3);

        List<User> verifiedUsers = users.stream()
                .filter(User::isVerified)
//                .filter(user -> user.isVerified())
                .collect(Collectors.toList());

        System.out.println("verifiedUsers = " + verifiedUsers);

        List<User> unverifiedUsers = users.stream()
                .filter(user -> !user.isVerified())
                .collect(Collectors.toList());
        System.out.println("unverifiedUsers = " + unverifiedUsers);

        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED);

        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR);

        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED);

        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR);

        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
        //Filter orders in Error state
        List<Order> errorOrders = orders.stream()
                .filter(order -> order.getStatus().equals(Order.OrderStatus.ERROR))
                .collect(Collectors.toList());
        System.out.println("errorOrders = " + errorOrders);
    }
}
