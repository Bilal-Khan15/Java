package oop;

public class Staff extends User {
    private String dept;

    public Staff(Integer id, String name, String dept) {
        super(id, name);
        this.dept = dept;
    }

    @Override
    protected void checkAccount() {
        System.out.println("Staff.java => checkAccount() called");
    }

    public void getBookInfo(){
        System.out.println("Staff.java => getBookInfo() called");
    }
}
