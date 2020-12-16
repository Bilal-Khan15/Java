package MySQL;

public class Student {

    private int id;
    private String rollNo;
    private String name;
    private String fatherName;
    private boolean setId;

    public Student(){

    }

    public Student(String rollNo, String name, String fatherName) {
        this.rollNo = rollNo;
        this.name = name;
        this.fatherName = fatherName;
        this.setId = false;
    }

    public boolean hasId(){
        return setId;
    }

    public void setId(int id) {
        this.id = id;
        this.setId = true;
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
        if(setId)
            return id;
        else
            return -1;
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
