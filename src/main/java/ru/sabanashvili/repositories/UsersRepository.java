package ru.sabanashvili.repositories;

import ru.sabanashvili.modules.User;

import java.util.List;

public interface UsersRepository {
    List<User> findAll();
}
