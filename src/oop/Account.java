package oop;

//Interface
public class Account implements IAccount{
    private int fine;

    public Account() {
        this.fine = 100;
    }

    public int calculateFine(){
        System.out.println("Account.java => calculateFine called");
        return this.fine;
    }

}
