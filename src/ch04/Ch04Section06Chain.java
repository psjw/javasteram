package ch04;


import ch04.model.Order;
import ch04.model.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ch04Section06Chain {
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
                .setVerified(false)
                .setEmailAddress("charlie@test.co.kr");
        List<User> users = Arrays.asList(user1, user2, user3);

        //검증되지 않은 이메일 리스트
        //How to do?
        List<String> emails = new ArrayList<>();
        for(User user : users){
            if(!user.isVerified()){
                String email = user.getEmailAddress();
                emails.add(email);
            }
        }
        System.out.println("emails = " + emails);


        //What to do?
        List<String> emails2 = users.stream().filter(user -> !user.isVerified())
                .map(User::getEmailAddress)
                .collect(Collectors.toList());
        System.out.println("emails2 = " + emails2);
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreateByUserId(101)
                .setCreateAt(now.minusHours(4));

        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreateByUserId(103)
                .setCreateAt(now.minusHours(1));

        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreateByUserId(102)
                .setCreateAt(now.minusHours(36));

        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreateByUserId(104)
                .setCreateAt(now.minusHours(30));

        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreateByUserId(101)
                .setCreateAt(now.minusHours(10));

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
        //TODO: ERROR 상태인 ORDER를 골라서 UserID를 리스트로 뽑아라, Find orders in Error status, and extract createByUserIds as a list
        List<Long> errorOrders = orders.stream().filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .map(Order::getCreateByUserId)
                .collect(Collectors.toList());

        System.out.println("errorOrders = " + errorOrders);

        // TODO: Find orders in ERROR status and created within 24 
        List<Order> within24hrsAndErrorOrders = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .filter(order -> order.getCreateAt().isAfter(now.minusHours(24)))
                .collect(Collectors.toList());
        System.out.println("within24hrsAndErrorOrders = " + within24hrsAndErrorOrders);
    }
}
