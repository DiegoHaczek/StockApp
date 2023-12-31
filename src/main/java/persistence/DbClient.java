package persistence;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class DbClient {

    public static String DATABASE_URL = "jdbc:h2:./src/main/java/db/stock_app;";

    public DbClient() {}

    @PostConstruct
    public void init() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void run(String query) {
        try (Connection con = DriverManager.getConnection(DATABASE_URL);
             Statement statement = con.createStatement()
        ) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Object> select(String query) {
        Map<String, Object> result = new HashMap<>();

        try (Connection con = DriverManager.getConnection(DATABASE_URL);
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(query)
        ) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            if (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object value = rs.getObject(i);
                    result.put(columnName, value);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Map<String, Object>> selectAll(String query) {
        List<Map<String, Object>> resultList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(DATABASE_URL);
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(query)
        ) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object value = rs.getObject(i);
                    row.put(columnName, value);
                }
                resultList.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }



}

