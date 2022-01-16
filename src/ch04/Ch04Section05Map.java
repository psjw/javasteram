package ch04;


import ch04.model.Order;
import ch04.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch04Section05Map {
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

        Stream<User> userStream = users.stream();
//        Stream<String> emailSteram = userStream.map(user -> user.getEmailAddress());
        Stream<String> emailSteram = userStream.map(User::getEmailAddress);
        List<String> emails = emailSteram.collect(Collectors.toList());
        System.out.println("emails = " + emails);

        List<String> userEmailList = users.stream().map(User::getEmailAddress).collect(Collectors.toList());
        System.out.println("userEmailList = " + userEmailList);


        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreateByUserId(101);

        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreateByUserId(103);

        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreateByUserId(102);

        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreateByUserId(104);

        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreateByUserId(101);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
        //TODO : CreateByUserId
        List<Long> createdByUserIds = orders.stream().map(Order::getCreateByUserId).collect(Collectors.toList());
        System.out.println("createdByUserIds = " + createdByUserIds);
    }
}
