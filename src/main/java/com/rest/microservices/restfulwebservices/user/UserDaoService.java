package com.rest.microservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int userCount = 0;


    static {
        users.add(new User(++userCount, "Cathy", LocalDate.of(1988, 12, 23)));
        users.add(new User(++userCount, "Robert", LocalDate.of(1964, 2, 24)));
        users.add(new User(++userCount, "Francis", LocalDate.of(1975, 5, 3)));
        users.add(new User(++userCount, "Paul", LocalDate.of(1994, 5, 14)));
        users.add(new User(++userCount, "Frank", LocalDate.of(1956, 10, 21)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findUser(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User createUser(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteUser(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
