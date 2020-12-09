package oop;

public class Main {

    public static void main(String[] args){
        Student bilal = new Student(1, "Muhammad Bilal", 14);
        bilal.verify(); // Inheritance : User.java => verify() called
        bilal.verify(1); // Overloading : Student.java => verify(int id) called
        bilal.getBookInfo();

        Staff ali = new Staff(2, "Ali Ahmed", "CS");
        ali.checkAccount();
        ali.getBookInfo();
    }
}
