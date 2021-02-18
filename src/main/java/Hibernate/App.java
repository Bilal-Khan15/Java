package Hibernate;

import Hibernate.dao.StudentDao;
import Hibernate.model.Student;

import java.util.List;

public class App {

    public static void main(String[] args) {

        StudentDao studentDao = new StudentDao();
        Student student = new Student("17K-3872", "Taneem", "Fazal");
        studentDao.saveStudent(student);

        student.setFatherName("Khanabi");
        student.setRollNo("17K-5486");
        studentDao.updateStudent(student);

        Student student2 = studentDao.getStudentById(student.getId());
        List<Student> students = studentDao.getAllStudents();
        students.forEach(student1 -> System.out.println(student1.getId()));
        studentDao.deleteStudentById(student.getId());
    }
}
