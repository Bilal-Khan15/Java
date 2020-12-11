package oop;

//Abstract Class
public abstract class User {
//    Private access modifier
    private Integer id;
    private String name;
    private IAccount usersAccount = new Account();

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void printFine(){
        System.out.println(this.name + "'s fine = " + usersAccount.calculateFine());
    }

    //    Default access modifier
    void verify(){
        System.out.println("User.java => verify() called");
    }

//    Protected access modifier
    protected void checkAccount(){
        System.out.println("User.java => checkAccount() called");
    }

//    Public access modifier
    public abstract void getBookInfo();

    public String getName() {
        return name;
    }
}
