package MySQL;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.sql.*;

@Path("/hello-world")
public class Main {

    static Connection conn = DBConnection.getConnect();

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String add(@FormParam("rollNo") String rollNo,
                      @FormParam("name") String name,
                      @FormParam("fatherName") String fatherName,
                      @Context HttpServletResponse servletResponse) throws IOException {
        Student student = new Student(rollNo, name, fatherName);
        addStudent(student);
        readStudent(student.getId());

        return ("{\"result\" : \"Added, " + name + "\"}");
    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@FormParam("id") int id,
                         @FormParam("rollNo") String rollNo,
                         @FormParam("name") String name,
                         @FormParam("fatherName") String fatherName,
                         @Context HttpServletResponse servletResponse) throws IOException {
        Student student = new Student(rollNo, name, fatherName);
        student.setId(id);
        updateStudent(student);
        readStudent(student.getId());

        return ("{\"result\" : \"Updated, " + name + "\"}");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String add(@PathParam("id") int id,
                      @Context HttpServletResponse servletResponse) throws IOException, SQLException {

        ResultSet result = readStudent(id);

        return ("{\"result\" : \"" + result.getString("name") + " s / o " +
                result.getString("fatherName") + " having Roll No. " +
                result.getString("rollNo") + " read successfully!" + "\"}");
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String remove(@PathParam("id") int id,
                         @Context HttpServletResponse servletResponse) throws IOException {
        removeStudent(id);

        return ("{\"result\" : \"Deleted, id = " + id + "\"}");
    }

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

    public static ResultSet readStudent(int id){

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
                return result;
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
