package MySQL;

public class Student {

    private int id;
    private String rollNo;
    private String name;
    private String fatherName;

    public Student(){

    }

    public Student(String rollNo, String name, String fatherName) {
        this.rollNo = rollNo;
        this.name = name;
        this.fatherName = fatherName;
    }

    public Student(int id, String rollNo, String name, String fatherName) {
        this.id = id;
        this.rollNo = rollNo;
        this.name = name;
        this.fatherName = fatherName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public int getId() {
        return id;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }
}
