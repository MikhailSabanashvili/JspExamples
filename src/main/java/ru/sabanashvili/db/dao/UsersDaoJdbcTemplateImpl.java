package ru.sabanashvili.db.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.sabanashvili.db.model.Car;
import ru.sabanashvili.db.model.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UsersDaoJdbcTemplateImpl implements UsersDao {
    private JdbcTemplate jdbcTemplate;
    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM fix_user";
    //language=SQL
    private final String SQL_SELECT_BY_FIRST_NAME = "" +
            "SELECT * FROM fix_user WHERE first_name = ?";
    //language=SQL
    private final String SQL_SELECT_USER_WITH_CARS = "" +
            "SELECT fix_user.*, fix_car.id as car_id, fix_car.model FROM fix_user LEFT JOIN fix_car ON fix_user.id = fix_car.owner_id WHERE fix_user.id = ?";

    private Map<Integer, User> usersMap = new HashMap<>();
    //правило, по которому строка resultSet-а преобразуется в объект
    //вытаскиваем пользователя и все его машины
    private final RowMapper<User> userRowMapper = (resultSet, i) -> {
        Integer id = resultSet.getInt("id");
        if(!usersMap.containsKey(id)){
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            User user = new User(id, firstName, lastName, new ArrayList<>());
            usersMap.put(id, user);
        }

        Car car = new Car(resultSet.getInt("car_id"),
                resultSet.getString("model"), usersMap.get(id));

        usersMap.get(id).getCars().add(car);
        return usersMap.get(id);
    };

    public UsersDaoJdbcTemplateImpl(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<User> findAllByFirstName(String firstName) {
        return jdbcTemplate.query(SQL_SELECT_BY_FIRST_NAME, userRowMapper, firstName);
    }

    @Override
    public Optional<User> find(Integer id) {
        jdbcTemplate.query(SQL_SELECT_USER_WITH_CARS, userRowMapper, id);
        if(usersMap.containsKey(id)){
            return Optional.of(usersMap.get(id));
        }
        return Optional.empty();
    }

    @Override
    public void save(User model) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, userRowMapper);
    }
}
