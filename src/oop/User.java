package oop;

public class User {
//    Private access modifier
    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    //    Public access modifier
    public void verify(){
        System.out.println("User.java => verify() called");
    }

//    Protected access modifier
    protected void checkAccount(){
        System.out.println("User.java => checkAccount() called");
    }

//    Default access modifier
    void getBookInfo(){
        System.out.println("User.java => getBookInfo() called");
    }
}
