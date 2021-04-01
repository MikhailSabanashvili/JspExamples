package ru.sabanashvili.repositories;

import ru.sabanashvili.fake.FakeStorage;
import ru.sabanashvili.modules.User;
import java.util.List;

//класс-хранилище, который возвращает трех пользаков

public class UsersRepositoryInMemoryImpl implements UsersRepository {
    public List<User> findAll(){
        return FakeStorage.storage().users();
    }

    @Override
    public void save(User user) {
        FakeStorage.storage().users().add(user);
    }

    @Override
    public boolean isExist(String name, String password) {
        for (User user: FakeStorage.storage().users()) {
            if(user.getName().equals(name) &&
            user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

}
