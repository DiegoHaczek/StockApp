package dao;

import db.DbClient;
import model.User;
import java.util.Map;

public class UserDao{

    private final String CREATE_TABLE = "create table if not exists `USER`(" +
            "ID int not null auto_increment, " +
            "NAME varchar not null, " +
            "SURNAME varchar not null, " +
            "EMAIL varchar unique not null, " +
            "PASSWORD varchar not null, " +
            "PRIMARY KEY (ID)); ";

    private final String EXISTS_BY_EMAIL = "select count(*) as \"exists\" from `USER` where email = '%s' ;";

    private final String SELECT_BY_EMAIL = "select * from `USER` where email = '%s' ;";


    private final String INSERT = "insert into `USER` (NAME, SURNAME, EMAIL, PASSWORD)" +
            " values ('%s', '%s', '%s', '%s');";

    private final String SELECT_ALL = "select * from `USER`";

    private final DbClient dbClient;

    public UserDao(DbClient dbClient) {
        this.dbClient = dbClient;
        dbClient.run(CREATE_TABLE);
    }

    public User findByEmail(String email) {
       Map<String,Object> queryResult = dbClient.select(String.format(SELECT_BY_EMAIL,email));
       return new User(
               (String) queryResult.get("NAME"),
               (String) queryResult.get("SURNAME"),
               (String) queryResult.get("EMAIL"),
               (String) queryResult.get("PASSWORD")
       );

    }

    public boolean existsByEmail(String email)  {
        Long exists = (Long) dbClient.select(String.format(EXISTS_BY_EMAIL,email)).get("exists");
        return exists != 0;
    }

    public void save(User user) {
        dbClient.run(String.format(INSERT,
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getPassword()));
    }

}

