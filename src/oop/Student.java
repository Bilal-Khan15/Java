package oop;

//Inheritance
public class Student extends User {
    private Integer grade;

    public Student(Integer id, String name, Integer grade) {
        super(id, name);
        this.grade = grade;
    }

//    Overloading
    public void verify(int id){
        System.out.println("Student.java => verify(int id) called");
    }
}
