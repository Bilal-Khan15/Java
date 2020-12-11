package MySQL;

import java.sql.*;

public class Main {

    static Connection conn = DBConnection.getConnect();

    public static void main(String[] args) {

        Main obj = new Main();
        Student student = new Student("17K2551", "Ahmed Ali", "Javed Ahmed");

        obj.saveOrUpdate(student);
        obj.readStudent(student.getId());

        student.setName("Taha Aslam");
        obj.saveOrUpdate(student);
        obj.readStudent(student.getId());

        obj.deleteStudent(10);
    }

    public void saveOrUpdate(Student student){

        String updateQuery = "UPDATE students SET rollNo=?, name=?, fatherName=? WHERE id=?";
        String insertQuery = "INSERT INTO students (rollNo, name, fatherName) VALUES (?, ?, ?)";
        String getId = "SELECT LAST_INSERT_ID()";

        if(!student.hasId()){
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
        else {
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
    }

    public void readStudent(int id){

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
