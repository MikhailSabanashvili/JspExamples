package ru.sabanashvili.db.dao;


import ru.sabanashvili.db.model.User;

import java.util.List;

public interface UsersDao extends CrudDao<User> {
    List<User> findAllByFirstName(String firstName);
}
