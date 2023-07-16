package db;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DbClient {

    public static String DATABASE_URL = "jdbc:h2:./src/main/java/db/stock_app;";

    static {
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


}

