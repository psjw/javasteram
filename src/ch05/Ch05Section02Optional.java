package ch05;

import ch05.model.User;

import java.util.Optional;

public class Ch05Section02Optional {
    public static void main(String[] args) {
        Optional<User> maybeUser =Optional.ofNullable(maybeGetUser(true));
        maybeUser.ifPresent(user -> System.out.println("user = " + user));
        Optional<Integer> maybeId = Optional.ofNullable(maybeGetUser(true))
                .map(User::getId);
        maybeId.ifPresent(id -> System.out.println("id = " + id));

        String userName = Optional.ofNullable(maybeGetUser(true))
                .map(User::getName)
                .map(name -> "The name is " + name)
                .orElse("Name is empty");

        System.out.println("userName = " + userName);

//        Optional<Optional<String>> maybeEmail = Optional.ofNullable(maybeGetUser(false))
//                .map(User::getEmailAddress)
        //flatmap으로 Optional 하나로 만들어줌
        Optional<String> maybeEmail = Optional.ofNullable(maybeGetUser(false))
                .flatMap(User::getEmailAddress);
        maybeEmail.ifPresent(System.out::println);

    }

    public static User maybeGetUser(boolean returnUser){
        if(returnUser){
            return new User()
                    .setId(1001)
                    .setName("Alice")
                    .setEmailAddress("alice@test.co.kr")
                    .setVerified(false);
        }
        return null;
    }
}
