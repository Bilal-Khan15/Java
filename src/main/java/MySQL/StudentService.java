package MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentService {

    static Connection conn = DBConnection.getConnect();

    public static void addStudent(Student student){

        String insertQuery = "INSERT INTO students (rollNo, name, fatherName) VALUES (?, ?, ?)";
        String getId = "SELECT LAST_INSERT_ID()";

        try {
            PreparedStatement statement = conn.prepareStatement(insertQuery);
            statement.setString(1, student.getRollNo());
            statement.setString(2, student.getName());
            statement.setString(3, student.getFatherName());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {

                try {
                    Statement idStatement = conn.createStatement();
                    ResultSet result = idStatement.executeQuery(getId);

                    if(result.next())
                        student.setId(result.getInt(1));

                    System.out.println("A new user was inserted successfully!");
                } catch (Exception e){
                    System.out.println("ID Retrieval Failed");
                }

            } else {
                System.out.println("Insertion Failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updateStudent(Student student){

        String updateQuery = "UPDATE students SET rollNo=?, name=?, fatherName=? WHERE id=?";

        try{
            PreparedStatement statement = conn.prepareStatement(updateQuery);
            statement.setString(1, student.getRollNo());
            statement.setString(2, student.getName());
            statement.setString(3, student.getFatherName());
            statement.setInt(4, student.getId());
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

    public static Student readStudent(int id){

        String sql = "SELECT * FROM students WHERE id=?";
        ResultSet result;

        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            result = statement.executeQuery();

            if(result.next()){
                System.out.println(result.getString("name") + " s/o " +
                        result.getString("fatherName") + " having Roll No. " +
                        result.getString("rollNo") + " read successfully!");

                Student student = new Student(result.getInt("id"),
                        result.getString("rollNo"),
                        result.getString("name"),
                        result.getString("fatherName"));
                return student;
            } else{
                System.out.println("Read Failed");
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static void removeStudent(int id){

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
