package ru.sabanashvili.repositories;

import ru.sabanashvili.modules.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//класс-хранилище, который возвращает трех пользаков

public class UsersRepositoryInMemoryImpl implements UsersRepository {
    private List<User> users;

    public UsersRepositoryInMemoryImpl() {
        this.users = new ArrayList<>();
        User user = new User("Misha", "qwerty", LocalDate.parse("1994-05-13"));
        User user1 = new User("Misha1", "qwerty", LocalDate.parse("1994-05-13"));
        User user2 = new User("Misha2", "qwerty", LocalDate.parse("1994-05-13"));
        users.add(user);
        users.add(user1);
        users.add(user2);
    }

    public List<User> findAll(){
        return this.users;
    }

}
