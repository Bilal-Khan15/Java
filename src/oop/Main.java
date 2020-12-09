package oop;

import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    static Student student;
    static Staff staff;
    static int id = 0;

    public static void main(String[] args){

        ArrayList<Student> studentsArrayList = getStudents();  // For Loop
        LinkedList<Staff> staffLinkedList = getStaff();  // Do..While Loop

//        Non-Static Method
        Main main = new Main();
        main.showStudents(studentsArrayList); // For-Each Loop

//        Static Method
        showStaff(staffLinkedList);  // ListIterator

        checkException();
    }

    public static ArrayList<Student> getStudents() {

        ArrayList<Student> studentsList = new ArrayList<Student>();

        for(int counter=0; counter<=3; counter++){
            try{
                if(counter == 3){
                    throw new ArrayIndexOutOfBoundsException("Exception thrown by Bilal in getStudents()");
                }
                student = new Student(id++, "student"+counter , counter+5);
                studentsList.add(student);
            }catch (Exception e){
                System.out.println("Error: " + e);
            }finally {
                continue;
            }
        }
        return studentsList;
    }

    public static LinkedList<Staff> getStaff(){

        LinkedList<Staff> staffList = new LinkedList<>();
        int counter = 0;

        do{
            staff = new Staff(id++, "staff"+counter , "Dept"+5);
            staffList.add(staff);

            counter++;
        }while(counter < 3);

        return staffList;
    }

    public static void showStaff(LinkedList<Staff> staffList){
        ListIterator<Staff> staffIterator = staffList.listIterator();

        while(staffIterator.hasNext()){
            staff = staffIterator.next();
            staff.checkAccount();
            staff.getBookInfo();
            System.out.println("\n");
        }
        System.out.println("====================");
    }

    public void showStudents(ArrayList<Student> studentsList){

        int counter = 0;

        for (Student student : studentsList){
            student = studentsList.get(counter);
            student.verify();
            student.verify(); // Inheritance : User.java => verify() called
            student.verify(1); // Overloading : Student.java => verify(int id) called
            student.getBookInfo();
            student.printFine();
            System.out.println("\n");

            counter++;
        }

        System.out.println("====================");
    }

    public static void checkException(){
        int[] array = {10, 20};

        try{
            for(int i=0; i<=array.length; i++){
                System.out.println(i + ". " + array[i]);
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
        }finally {
            System.out.println("2. 404");
        }
    }
}

