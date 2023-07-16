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

    private final String SELECT_ALL_BY_USER = "select * from PRODUCT where USER_ID = %s ;";

    private final String DELETE_PRODUCT = "delete from PRODUCT where ID = %d";

    private final String EDIT_PRODUCT = "update PRODUCT" +
            " set NAME = '%s', CATEGORY = '%s', BRAND = '%s', STOCK = %d, PRICE =%s " +
            " where ID = %d;";

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

    public List<Product> getAllByUser(int userId) {
        return dbClient.selectAll(String.format(SELECT_ALL_BY_USER, userId))
                .stream()
                .map(this::mapProductFromQuery)
                .collect(Collectors.toList());
    }

    public void delete (int productId) {
        dbClient.run(String.format(DELETE_PRODUCT,productId));
    }

    public void edit (Product product) {
        dbClient.run(String.format(EDIT_PRODUCT,
                product.getName(),
                product.getCategory(),
                product.getBrand(),
                product.getStock(),
                product.getPrice(),
                product.getId()));
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
