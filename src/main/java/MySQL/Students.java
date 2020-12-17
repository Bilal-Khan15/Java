package MySQL;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.sql.*;

@Path("/student")
public class Students {

    StudentService studentService = new StudentService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String add(Student student) {
        studentService.addStudent(student);
        studentService.readStudent(student.getId());

        return ("{\"result\" : \"Added, " + student.getName() + "\"}");
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String update(Student student) {
        studentService.updateStudent(student);
        studentService.readStudent(student.getId());

        return ("{\"result\" : \"Updated, " + student.getName() + "\"}");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Student get(@PathParam("id") int id,
                      @Context HttpServletResponse servletResponse) throws IOException, SQLException {

        Student student = studentService.readStudent(id);

        return student;
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String remove(@PathParam("id") int id,
                         @Context HttpServletResponse servletResponse) throws IOException {
        studentService.removeStudent(id);

        return ("{\"result\" : \"Deleted, id = " + id + "\"}");
    }
}
