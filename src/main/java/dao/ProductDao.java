package dao;

import model.Product;
import persistence.DbClient;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductDao {

    private final String CREATE_TABLE = "create table if not exists PRODUCT(" +
            "ID int not null auto_increment, " +
            "USER_ID int not null," +
            "NAME varchar not null, " +
            "CATEGORY varchar not null," +
            "BRAND varchar not null," +
            "STOCK int not null default 0," +
            "PRICE numeric not null," +
            "PRIMARY KEY (ID)," +
            "FOREIGN KEY (USER_ID) references `USER`(ID)); ";

    private final String INSERT = "insert into PRODUCT (USER_ID,NAME,CATEGORY,BRAND,STOCK,PRICE)" +
            " values (%d, '%s', '%s', '%s', %d, %s);";

    private final String SELECT_ALL = "select * from PRODUCT";

    private final String DROP_TABLE = "drop table PRODUCT";

    private final DbClient dbClient;

    public ProductDao(DbClient dbClient) {
        this.dbClient = dbClient;
        dbClient.run(CREATE_TABLE);
    }

    public void save(Product product) {
        dbClient.run(String.format(INSERT,
                product.getUserId(),
                product.getName(),
                product.getCategory(),
                product.getBrand(),
                product.getStock(),
                product.getPrice()));
    }

    public List<Product> getAll() {
        return dbClient.selectAll(SELECT_ALL)
                .stream()
                .map(this::mapProductFromQuery)
                .collect(Collectors.toList());
    }

    public Product mapProductFromQuery(Map<String,Object> queryResult) {
        return new Product(
                (int) queryResult.get("ID"),
                (int) queryResult.get("USER_ID"),
                (String) queryResult.get("CATEGORY"),
                (String) queryResult.get("BRAND"),
                (String) queryResult.get("NAME"),
                (Integer) queryResult.get("STOCK"),
                (BigDecimal) queryResult.get("PRICE")
        );
    }
}
