package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCconfig {
    public static Connection con;
    public static Connection create() {
        try {
//			Class.forName("com.mysql.jdbc.Driver");
            String user = "root";
            String password = "root";
            String url= "jdbc:mysql://localhost:3306/demo";
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
