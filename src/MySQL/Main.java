package MySQL;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Main obj = new Main();
        obj.insertStudent("17K1542", "Ahmed Ali", "Javed Ahmed");
        obj.readStudent(4);
        obj.updateStudent(4, "17K4869", "Zain", "Abid");
        obj.readStudent(4);
        obj.deleteStudent(4);

    }

    public void insertStudent(String rollNo, String name, String fatherName){

        db_connection obj = new db_connection();
        Connection conn = obj.getConnect();

        String sql = "INSERT INTO students (rollNo, name, fatherName) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, rollNo);
            statement.setString(2, name);
            statement.setString(3, fatherName);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            } else {
                System.out.println("Insertion Failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateStudent(int id, String rollNo, String name, String fatherName){
        db_connection obj = new db_connection();
        Connection conn = obj.getConnect();

        String sql = "UPDATE students SET rollNo=?, name=?, fatherName=? WHERE id=?";

        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, rollNo);
            statement.setString(2, name);
            statement.setString(3, fatherName);
            statement.setInt(4, id);
            int rowUpdated = statement.executeUpdate();

            if(rowUpdated > 0){
                System.out.println("User was updated successfully!");
            } else{
                System.out.println("Update Failed");
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void readStudent(int id){
        db_connection obj = new db_connection();
        Connection conn = obj.getConnect();

        String sql = "SELECT * FROM students WHERE id=?";

        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if(result.next()){
                System.out.println(result.getString("name") + " s/o " +
                        result.getString("fatherName") + " having Roll No. " +
                        result.getString("rollNo") + " read successfully!");
            } else{
                System.out.println("Read Failed");
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void deleteStudent(int id){

        db_connection obj = new db_connection();
        Connection conn = obj.getConnect();

        String sql = "DELETE FROM students WHERE id=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("User was deleted successfully!");
            } else {
                System.out.println("Deletion Failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
