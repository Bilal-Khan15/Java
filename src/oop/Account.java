package oop;

//Interface
public class Account implements IAccount{
    final int fine = 100;  // final

    public Account( ) {
//        this.fine = 10;
    }

    public int calculateFine(){
        System.out.println("Account.java => calculateFine called");
        return this.fine;
    }

}
