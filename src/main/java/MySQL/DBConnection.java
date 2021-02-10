package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnect(){

        Connection conn = null;
        String dbURL = "jdbc:mysql://localhost:3306/Student";
        String username = "root";
        String password = "root";

        try {

            conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("DB Connected");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return conn;
    }
}
