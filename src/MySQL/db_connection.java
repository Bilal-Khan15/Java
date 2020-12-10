package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_connection {

    public static void main(String[] args) {
        db_connection obj = new db_connection();
        System.out.println(obj.getConnect());
    }

    public Connection getConnect(){

        Connection conn = null;
        String dbURL = "jdbc:mysql://localhost:3306/Student";
        String username = "root";
        String password = "root";

        try {

            conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("Connected");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return conn;
    }
}
