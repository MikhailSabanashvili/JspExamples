package ru.sabanashvili.fake;

import ru.sabanashvili.modules.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FakeStorage {
    private static final FakeStorage storage;

    static{
        storage = new FakeStorage();
    }

    private List<User> users;

    private FakeStorage(){
        this.users = new ArrayList<>();
        User user = new User("Misha", "qwerty", LocalDate.parse("1994-05-13"));
        User user1 = new User("Misha1", "qwerty", LocalDate.parse("1994-05-13"));
        User user2 = new User("Misha2", "qwerty", LocalDate.parse("1994-05-13"));
        users.add(user);
        users.add(user1);
        users.add(user2);
    }

    public static FakeStorage storage(){
        return storage;
    }

    public List<User> users(){
        return users;
    }

}
